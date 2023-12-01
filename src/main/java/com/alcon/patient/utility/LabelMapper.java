package com.alcon.patient.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.alcon.patient.dto.card.CaseDTO;
import com.alcon.patient.dto.card.CustomSortedLens;
import com.alcon.patient.dto.card.PatientCardResponseDTO;
import com.alcon.patient.dto.card.SortedCaseDetailsDTO;
import com.alcon.patient.entity.Lens;


public class LabelMapper {   
        
    public static PatientCardResponseDTO mapResponseDTO(List<CustomSortedLens> list, Integer totalCases, List<Lens> lensList  ) {
    	PatientCardResponseDTO result = new PatientCardResponseDTO();
        result.setNumberOfCase(totalCases);
        result.setSortedCase(list.size());
        result.setPendingcases(totalCases-list.size());
        if(result.getSortedCase().intValue() == 50){
            result.setTriggerModel(true);
        }
        if(result.getSortedCase().intValue() > 50 && result.getSortedCase().intValue()%10 ==0){
            result.setTriggerModel(true);
        }
        List<SortedCaseDetailsDTO> lenses = new ArrayList<>();
        Map<Integer, List<CustomSortedLens>> map =  list.stream().collect(Collectors.groupingBy(CustomSortedLens::getLensId));
        map.keySet().stream().forEach(key -> {
            
        	SortedCaseDetailsDTO lens = new SortedCaseDetailsDTO();
            lens.setLensId(key);
            lens.setLensName(map.get(key).get(0).getLensName());
            lens.setSorted(map.get(key).size());
            List<CaseDTO> cases = new ArrayList<>();
            
            map.get(key).stream().forEach(models -> {
            	CaseDTO currentCase = new CaseDTO();
                currentCase.setCaseId(models.getUserSurveyId());
                currentCase.setCaseName(models.getUserSurveyId());
                cases.add(currentCase);
            });
            lens.setCases(cases);
            lenses.add(lens);
        });
        
        Function<Lens,SortedCaseDetailsDTO> mapper = (lensObj -> {
        	SortedCaseDetailsDTO res = new SortedCaseDetailsDTO();
        	res.setLensId(lensObj.getLensId());
        	res.setLensName(lensObj.getLensName());
        	return res;
        });
        
        List<SortedCaseDetailsDTO> convertedLensList = lensList.stream().map(mapper).collect(Collectors.toList());
        
        if(lenses.size() != lensList.size()){
            List<Integer> lensIds = lenses.stream().map(l-> l.getLensId()).collect(Collectors.toList());
            List<SortedCaseDetailsDTO> remainingList = convertedLensList.stream().filter(l -> !lensIds.contains(l.getLensId())).collect(Collectors.toList());
            remainingList.stream().forEach(l -> {
                lenses.add(l);
            });
        }
        result.setLens(lenses);
        return result;
    }
}