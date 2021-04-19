package it.sogei.svildep.indirizziservice.controller;

import it.sogei.svildep.indirizziservice.dto.AssociaDissociaIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.MessageDto;
import it.sogei.svildep.indirizziservice.exception.SvildepException;
import it.sogei.svildep.indirizziservice.service.IndirizzoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("indirizzo")
@RequiredArgsConstructor
public class IndirizzoController {

    private final IndirizzoService indirizzoService;


    @GetMapping("/{id}")
    public ResponseEntity<List<IndirizzoDto>> lista(@PathVariable("id") String id) throws SvildepException {
        return ResponseEntity.ok().body(indirizzoService.findAllBySoggetto(Long.parseLong(id)));
    }

    @GetMapping("")
    public ResponseEntity<List<IndirizzoDto>> listaDaAnagrafe() throws SvildepException {
        return ResponseEntity.ok().body(indirizzoService.listaDaAnagrafe());
    }


    @PostMapping("nuovoIndirizzo")
    public ResponseEntity<MessageDto>nuovoIndirizzo(@Valid @RequestBody InsertIndirizzoDto insertIndirizzoDto,
                                            BindingResult bindingResult) throws Exception {

        // aggiustare il modo di stampare l'errore( staccare e renderlo migliore!!)
        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult.getAllErrors().stream()
                .map(error->error.getDefaultMessage()).reduce("",(str1,str2)->str1+str2));
        return ResponseEntity.ok().body(indirizzoService.insertIndirizzo(insertIndirizzoDto));
    }

    @PutMapping("associa")
    public ResponseEntity<MessageDto>associaASoggetto(@Valid @RequestBody AssociaDissociaIndirizzoDto associaDissociaIndirizzoDto,
                                                      BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(indirizzoService.associaASoggetto(associaDissociaIndirizzoDto));

    }
    @PutMapping("chiusuraAssociazione")
    public ResponseEntity<MessageDto>chiusura(@Valid @RequestBody AssociaDissociaIndirizzoDto associaDissociaIndirizzoDto,
                                                      BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(indirizzoService.chiusuraAssociazione(associaDissociaIndirizzoDto));

    }




}
