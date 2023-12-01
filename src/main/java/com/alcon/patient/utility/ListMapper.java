package com.alcon.patient.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alcon.patient.dto.card.QuestionAnswerDTO;
import com.alcon.patient.dto.list.Answer;
import com.alcon.patient.dto.list.CaseDetailsDTO;
import com.alcon.patient.dto.list.MasterResponse;
import com.alcon.patient.dto.list.PatientListResponseDTO;
import com.alcon.patient.dto.list.Question;

public class ListMapper {

	private static final Integer naSeq = 9;

	public static PatientListResponseDTO mapResponseDTO(List<Question> questions, List<Answer> answers,
			List<MasterResponse> responses) {
		PatientListResponseDTO result = new PatientListResponseDTO();
		List<CaseDetailsDTO> CaseDetailsDTO = new ArrayList<>();

		Map<String, List<MasterResponse>> map = responses.stream()
				.collect(Collectors.groupingBy(MasterResponse::getMasterResponseCaseId));

		map.keySet().stream().forEach(key -> {

			CaseDetailsDTO indCase = new CaseDetailsDTO();
			List<QuestionAnswerDTO> qaDTOResponse = new ArrayList<>();

			questions.stream().distinct().forEach(question -> {
				QuestionAnswerDTO qaDTO = new QuestionAnswerDTO();
				qaDTO.setQuestionCategory(question.getQuestionDescription());
				qaDTO.setQuestionDesc(question.getQuestionDetailedDescription());
				qaDTO.setQuestionId(question.getQuestionId());
				qaDTO.setQuestionSeq(question.getQuestionSeq());
				qaDTO.setOptionsText(answers.stream()
						.filter(ans -> ans.getQuestionId().intValue() == qaDTO.getQuestionId().intValue())
						.filter(ans -> ans.getSequence().intValue() != naSeq).map(ans -> ans.getOptionValue())
						.collect(Collectors.joining(" | ")));

				qaDTO.setNumberOfOptions(Integer.parseInt(answers.stream()
						.filter(ans -> ans.getQuestionId().intValue() == qaDTO.getQuestionId().intValue())
						.filter(ans -> ans.getSequence().intValue() != naSeq).count() + ""));

				qaDTOResponse.add(qaDTO);

			});

			map.get(key).stream().forEach(masterResponse -> {

				indCase.setCaseId(masterResponse.getMasterResponseCaseId());
				indCase.setCaseName(masterResponse.getMasterResponseCaseId());

				QuestionAnswerDTO qaDTO = qaDTOResponse.stream()
						.filter(q -> q.getQuestionId().intValue() == masterResponse.getQuestionId().intValue())
						.findFirst().get();

				StringBuffer previousValue = new StringBuffer(qaDTO.getAnswer() != null ? qaDTO.getAnswer() : "");

				answers.stream()
						.filter(ans -> ans.getQuestionId().intValue() == masterResponse.getQuestionId().intValue())
						.filter(ans -> ans.getAnswerId().intValue() == masterResponse.getMasterResponseSelected()
								.intValue())
						.forEach(ans -> {
							qaDTO.setWeightage(ans.getOptionWeightage());
							qaDTO.setAnswerSequence(ans.getSequence() == naSeq ? 0 : ans.getSequence());
							qaDTOResponse.stream()
									.filter(q -> q.getQuestionId().intValue() == qaDTO.getQuestionId().intValue())
									.findFirst().ifPresent(q -> {

										if (previousValue.toString().equals("")) {

											previousValue.append(ans.getOptionValue());
										} else {
											previousValue.append(", ");
											previousValue.append(ans.getOptionValue());

										}

									});
							qaDTO.setAnswer((previousValue.toString()));
						});

				qaDTO.setNumberOfOptions(Integer.parseInt(answers.stream()
						.filter(ans -> ans.getQuestionId().intValue() == masterResponse.getQuestionId().intValue())
						.filter(ans -> ans.getSequence().intValue() != naSeq).count() + ""));
			});

			indCase.setResponses(qaDTOResponse);
			CaseDetailsDTO.add(indCase);

		});

		result.setBody(CaseDetailsDTO);
		return result;
	}
}