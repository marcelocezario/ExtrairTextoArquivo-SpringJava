package br.dev.mhc.ExtrairTextoImagem;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Teste {
	public static void main(String[] args) {
		Tesseract tesseract = new Tesseract();
		try {
			tesseract.setDatapath("D:\\Java\\Tess4J\\tessdata");
			
			// the path your tess data folder
			// inside the extracted file
			File file = new File("src\\main\\java\\br\\dev\\mhc\\ExtrairTextoImagem\\assets\\teste.png");
			String text = tesseract.doOCR(file);
			// path of your image file
			System.out.println("Teste png: " + text);
			
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");

			File file2 = new File("src\\main\\java\\br\\dev\\mhc\\ExtrairTextoImagem\\assets\\teste.pdf");
			String text2 = tesseract.doOCR(file2);
			System.out.println("Teste pdf: " + text2);

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");

			File file3 = new File("src\\main\\java\\br\\dev\\mhc\\ExtrairTextoImagem\\assets\\pdf_com_imagem.pdf");
			String text3 = tesseract.doOCR(file3);
			System.out.println("Teste pdf com imagem: " + text3);

			
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}
}
