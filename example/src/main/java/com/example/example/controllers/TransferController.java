package com.example.example.controllers;

import org.springframework.ui.Model;

//import ch.qos.logback.core.model.Model;
import com.example.example.models.Transfer;
import com.example.example.repo.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class TransferController {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferController(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @GetMapping("/transfer-main")
    public String transferMain(org.springframework.ui.Model model) {
        Iterable<Transfer> transfers = transferRepository.findAll();
        model.addAttribute("transfers", transfers);
        return "transfer-main";
    }

    @GetMapping("/transfer/add")
    public String transferAdd(org.springframework.ui.Model model) {
        Iterable<Transfer> transfers = transferRepository.findAll();
        model.addAttribute("transfers", transfers);
        return "transfer-add";
    }


    @PostMapping("/transfer/add")
    public String newTransferAdd(@RequestParam String name, @RequestParam String surname, @RequestParam String teamFrom, @RequestParam String teamInto, @RequestParam int amount, Model model) {
        Transfer transfer = new Transfer(name, surname, teamFrom, teamInto, amount);
        transferRepository.save(transfer);
        return "redirect:/transfer-main";
    }


    @GetMapping("/transfer/{id}")
    public String showDeleteConfirmation(@PathVariable("id") long id, Model model) {
        Transfer transfer = transferRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid transfer Id:" + id));
        model.addAttribute("transfer", transfer);
        return "transfer-delete";
    }

    @PostMapping("/transfer/delete/{id}")
    public String deleteTransfer(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid transfer Id:" + id));
        transferRepository.delete(transfer);
        return "redirect:/transfer-main";
    }

}


