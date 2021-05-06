package br.dev.mhc.ExtrairTextoArquivo.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class TesseractService {
	
	public String extrairTextoArquivo(File file) {
		Tesseract tesseract = new Tesseract();
		String texto = "";
		try {
			tesseract.setDatapath("src\\main\\resources\\Tess4J\\tessdata");
			texto = tesseract.doOCR(file);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		return texto;
	}
}
