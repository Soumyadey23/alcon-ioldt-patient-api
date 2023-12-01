package com.alcon.patient.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alcon.patient.dto.card.CustomSortedLens;
import com.alcon.patient.dto.card.PatientCardResponseDTO;
import com.alcon.patient.dto.card.PatientRequestDTO;
import com.alcon.patient.dto.list.Answer;
import com.alcon.patient.dto.list.CustomPatientList;
import com.alcon.patient.dto.list.MasterResponse;
import com.alcon.patient.dto.list.PatientListRequestDTO;
import com.alcon.patient.dto.list.PatientListResponseDTO;
import com.alcon.patient.dto.list.Question;
import com.alcon.patient.dto.mlops.InvokeTrainingRequestDTO;
import com.alcon.patient.entity.Answers;
import com.alcon.patient.entity.Lens;
import com.alcon.patient.entity.ModelInfo;
import com.alcon.patient.entity.ModelLabel;
import com.alcon.patient.entity.ModelMetrics;
import com.alcon.patient.entity.Questions;
import com.alcon.patient.entity.Surgeon;
import com.alcon.patient.entity.UserSurveyAnswers;
import com.alcon.patient.entity.Users;
import com.alcon.patient.exception.CardLabelException;
import com.alcon.patient.repository.AnswersRepository;
import com.alcon.patient.repository.LensRepository;
import com.alcon.patient.repository.ModelInfoRepository;
import com.alcon.patient.repository.ModelLabelRepository;
import com.alcon.patient.repository.SurgeonRepository;
import com.alcon.patient.repository.UserSurveyAnswersRepository;
import com.alcon.patient.repository.UsersRepository;
import com.alcon.patient.utility.CardMapper;
import com.alcon.patient.utility.ListMapper;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.transaction.Transactional;

@Service
public class PatientService {

	@Autowired
	private UserSurveyAnswersRepository userSurveyAnswersRepository;

	@Autowired
	private ModelLabelRepository modelLabelRepository;

	@Autowired
	private AnswersRepository answersRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private LensRepository lensRepository;

	@Autowired
	private SurgeonRepository surgeonRepository;
	
	@Autowired
	private ModelInfoRepository modelInfoRepository;
	
	@Autowired
	RestTemplate restTemplate;

	// @PersistenceContext
	// EntityManager em;

	public final String SMART_COUNSELOR = "smartcounselor";

	public final Integer NA_ANSWER_SEQUENCE = 9;
	
	public PatientListResponseDTO getPatientList(PatientListRequestDTO reqBody) {
		// TODO Auto-generated method stub
		List<String> allId = new ArrayList<>();
		allId = userSurveyAnswersRepository.getPatientList(SMART_COUNSELOR, false);

		List<String> sortedId = modelLabelRepository.getLabelledPatientList(reqBody.getSurgeonId());

		List<String> result = new ArrayList<String>();
		Random randomNum = new Random();
		List<String> remainingIds = allId.stream().filter(id -> !sortedId.contains(id)).collect(Collectors.toList());
		int randomNumber = randomNum.nextInt((remainingIds.size() - 10) > 0 ? (remainingIds.size() - 10)
				: ((remainingIds.size() - 10) == 0 ? 10 : 1));

		if (remainingIds.size() > 0 && randomNumber >= 0) {

			if (remainingIds.size() > 10) {
				result.addAll(remainingIds.stream().skip(randomNumber).limit(10).collect(Collectors.toList()));
			} else {
				result.addAll(remainingIds.stream().limit(10).collect(Collectors.toList()));
			}

		} else {
			if (sortedId.size() <= 0) {
				result.addAll(allId.stream().skip(randomNumber).limit(10).collect(Collectors.toList()));
			}

		}

		// TODO Change it to result
		List<CustomPatientList> unsortedPatients = userSurveyAnswersRepository.getUnsortedCards(result);
		List<MasterResponse> responses = new ArrayList<>();
		unsortedPatients.stream().forEach(card -> {
			MasterResponse masterResponse = new MasterResponse();
			masterResponse.setMasterResponseCaseId(card.getUserSurveyid());
			masterResponse.setMasterResponseSelected(card.getAnswerOptionId());
			masterResponse.setQuestionId(card.getQuestionId());
			responses.add(masterResponse);
		});

		List<Answers> qaList = answersRepository.getQuestionAnswersList(SMART_COUNSELOR, NA_ANSWER_SEQUENCE);

		List<Question> questions = new ArrayList<>();
		List<Answer> answers = new ArrayList<>();

		qaList.stream().forEach(qa -> {
			Question question = new Question();
			question.setQuestionId(qa.getQuestion().getQuestionId());
			question.setQuestionDescription(qa.getQuestion().getQuestionAbbreviatedLabel());
			question.setQuestionDetailedDescription(qa.getQuestion().getQuestionText());
			question.setQuestionSource(qa.getQuestion().getQuestionSource());
			question.setSelectionType(qa.getQuestion().getSelectionType());
			question.setQuestionSeq(qa.getQuestion().getQuestionSeq());

			Answer answer = new Answer();

			answer.setOptionValue(qa.getAnswerText());
			answer.setOptionWeightage(qa.getAnswerScore());
			answer.setQuestionId(qa.getQuestion().getQuestionId());
			answer.setSequence(qa.getAnswerSequence());
			answer.setAnswerId(qa.getAnswerId());

			questions.add(question);
			answers.add(answer);
		});

		PatientListResponseDTO patientList = ListMapper.mapResponseDTO(questions, answers, responses);

		return patientList;
	}

	public PatientCardResponseDTO getPatientDetails(PatientRequestDTO reqBody) {
		Integer totalCases = (int) usersRepository.countByIsSurgeonCaseFlag(false);
		List<CustomSortedLens> sortedCustomSortedLens = modelLabelRepository.getSortedLensList(reqBody.getSurgeonId());
		List<Lens> allLens = lensRepository.findAllByOrderByLensId();
		PatientCardResponseDTO response = CardMapper.mapResponseDTO(sortedCustomSortedLens, totalCases, allLens);
		return response;
	}

	// @Transactional
	@SuppressWarnings("null")
	public PatientCardResponseDTO sortCards(PatientRequestDTO reqBody) {
		ModelLabel modelLabel = null;
		System.out.println(reqBody.getCaseId());
		if(!reqBody.getCaseId().equals("na")) {
			ModelLabel labels = modelLabelRepository.findAllByUserSurveyIdAndPersonaId(reqBody.getCaseId(),
					reqBody.getSurgeonId());

			if (labels != null) {
				throw new CardLabelException("Card is already labelled");
			}

			modelLabel = new ModelLabel();
			modelLabel.setLensName(reqBody.getLensName());
			Surgeon surgeon = new Surgeon();
			surgeon.setSurgeonId(reqBody.getSurgeonId());
			Users user = new Users();
			user.setId(reqBody.getCaseId());

			Optional<Surgeon> surgeonList = surgeonRepository.findById(reqBody.getSurgeonId());
			modelLabel.setSurgeon(surgeonList.isPresent() ? surgeonList.get() : surgeon);

			Optional<Users> u = usersRepository.findById(reqBody.getCaseId());
			modelLabel.setUserSurvey(u.isPresent() ? u.get() : user);

			modelLabelRepository.save(modelLabel);
		}
		
		PatientCardResponseDTO response = new PatientCardResponseDTO();
		ModelInfo modelInfo = new ModelInfo();
		Boolean isChampion = false;
		
		// TODO Add modelLabel.getId()
		if (modelLabel != null || reqBody.getCaseId().equals("na")) {
			if(reqBody.getCaseId() != "na") {
				modelInfo = modelInfoRepository.findOneBySurgeonId(reqBody.getSurgeonId());
				modelInfo.setNumOfCases(modelInfo.getNumOfCases() != null ? modelInfo.getNumOfCases() + 1 : 1);
				modelInfoRepository.save(modelInfo);
			}
			response = this.getPatientDetails(reqBody);
			if (response.getSortedCase().intValue() == 50) {
				response.setTriggerModel(true);
				isChampion = true;
			}
			if (response.getSortedCase().intValue() > 50 && response.getSortedCase().intValue() % 10 == 0) {
				response.setTriggerModel(true);
			}
			if(response.getTriggerModel() && !reqBody.getCaseId().equals("na")) {
			  HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      InvokeTrainingRequestDTO invokeTrainingRequestDTO = new InvokeTrainingRequestDTO(reqBody.getSurgeonId().toString(), modelInfo.getModelId(), isChampion, false);
		      HttpEntity<InvokeTrainingRequestDTO> entity = new HttpEntity<InvokeTrainingRequestDTO>(invokeTrainingRequestDTO, headers);
		      restTemplate.exchange("https://xahxbk0un0.execute-api.us-east-1.amazonaws.com/dev/invoke_training", HttpMethod.POST, entity, Object.class).getBody();
			}
		}
		
		return response;
	}
}
