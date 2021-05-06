package br.dev.mhc.ExtrairTextoArquivo.resource;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.dev.mhc.ExtrairTextoArquivo.service.TesseractService;
import br.dev.mhc.ExtrairTextoArquivo.util.Util;

@RestController
@RequestMapping(value = "/files")
public class FileResource {
	
	@Autowired
	TesseractService service;
	
	@PostMapping
	public ResponseEntity<String> extrairTextoArquivo(@RequestParam(name = "file") MultipartFile file) {
		String retorno = "";
		try {
			retorno = service.extrairTextoArquivo(Util.multipartToFile(file,
					UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename())));
		} catch (IllegalStateException e) {
			retorno = "Não foi possível converter arquivo!";
		} catch (IOException e) {
			retorno = "Não foi possível converter arquivo!";
		}
		return ResponseEntity.ok().body(retorno);
	}
}
