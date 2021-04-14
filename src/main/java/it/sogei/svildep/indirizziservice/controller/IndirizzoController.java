package it.sogei.svildep.indirizziservice.controller;

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

    @GetMapping
    public ResponseEntity<List<IndirizzoDto>> lista() throws SvildepException {
        return ResponseEntity.ok().body(indirizzoService.getAll());
    }

    @PostMapping("nuovoIndirizzo")
    public ResponseEntity<MessageDto>nuovoIndirizzo(@Valid @RequestBody InsertIndirizzoDto insertIndirizzoDto,
                                            BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
        return ResponseEntity.ok().body(indirizzoService.insertIndirizzo(insertIndirizzoDto));
    }

 //   @PutMapping
 //   public ResponseEntity<MessageDto>associaASoggetto(@Valid @RequestBody AssociaIndirizzoDto associaIndirizzoDto,
 //                                                     BindingResult bindingResult) throws Exception{
 //       if (bindingResult.hasErrors()) throw new SvildepException(bindingResult);
 //       return ResponseEntity.ok().body(indirizzoService.associaASoggetto(associaIndirizzoDto));

 //   }



}
