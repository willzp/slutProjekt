package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller implements ErrorController {

	plusCalculation plus = new plusCalculation();
	minusCalculation minus = new minusCalculation();
	timesCalculation times = new timesCalculation();
	getResults results = new getResults();
	game game = new game();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void redirectToDokumentation(HttpServletResponse response) throws IOException {
		response.sendRedirect("https://willzp.github.io/KalkylatorApiDokumentation/");

	}

	@RequestMapping(value = "/img", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(HttpServletResponse response) throws IOException {

		var imgFile = new ClassPathResource("static/picture.jpeg");
		if (Math.random() < 0.5) {
			imgFile = new ClassPathResource("static/picture2.jpeg");
		}

		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	@RequestMapping(value = "/kalkylator", method = RequestMethod.GET)
	public String CalculationType(String nr1, String nr2, String typ) {

		if (typ.equals("plus")) {
			return plus.Plus(nr1, nr2);
		}
		if (typ.equals("minus")) {
			return minus.Minus(nr1, nr2);
		}
		if (typ.equals("ganger")) {
			return times.Times(nr1, nr2);
		}
		return "Ange giltigt räknesätt";
	}

	@RequestMapping(value = "/showCsvFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCsvFileScanner() throws IOException {
		csvFileReader myReader = new csvFileReader();

		String text = myReader.readFile("static/sample.csv");
		return text;
	}

	@RequestMapping(path = "/stensaxpåse", method = RequestMethod.GET)
	public String game(String move) {
		return game.Game(move);
	}

	@RequestMapping(path = "/stensaxpåseresultat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String gameResult() {
		return results.GetResults();
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(HttpServletResponse response) {

		if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
			return "404 not found";
		} else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return "error 500";
		} else {

			return "error, try agin!";
		}

	}

}
