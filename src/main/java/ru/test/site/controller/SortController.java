package ru.test.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.site.BubbleSort;
import ru.test.site.model.SortResult;
import ru.test.site.model.SortedElement;
import ru.test.site.repository.SortResultRepository;
import ru.test.site.repository.SortedElementRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
public class SortController {

    @Autowired
    private SortedElementRepository sortedElementRepository;
    @Autowired
    private SortResultRepository sortResultRepository;


    @GetMapping("/")
    public String home() {
        return "sort-page";
    }

    @PostMapping("/sort-result")
    public String resultPage(@RequestParam("array") String arrayString, @RequestParam("ascending") Boolean ascending, Model model) {
        int[] array = Arrays.stream(arrayString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sortedArray = BubbleSort.sort(array, ascending);
        String sortedArrayString = Arrays.toString(sortedArray);
        SortResult sortResult = new SortResult();
        sortResult.setSortDate(Calendar.getInstance());
        sortResultRepository.save(sortResult);
        for (int i = 0; i < sortedArray.length; i++) {
            SortedElement sortedElement = new SortedElement();
            sortedElement.setValue(array[i]);
            sortedElement.setIndexNumber(i);
            sortedElement.setSortResultId(sortResult);
            sortedElementRepository.save(sortedElement);
        }
        model.addAttribute("sortedArray", sortedArrayString);
        model.addAttribute("sortId", sortResult.getId());

        return "result-page";
    }

    @GetMapping("/sort-history")
    public String sortHistoryPage(Model model) {
        Iterable<SortResult> sortResultList = sortResultRepository.findAll();
        model.addAttribute("results", sortResultList);
        return "sort-history-page";
    }

    @GetMapping("/getSortedArray")
    @ResponseBody
    public List<SortedElement> getSortedArray(@RequestParam("id") Long id) {
        SortResult sortResult = sortResultRepository.findSortResultById(id);
        return sortedElementRepository.findSortedElementsBySortResultId(sortResult);
    }

}
