package fon.is.fpis.stateful.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DateFormatter implements Formatter<LocalDate>{

	@Override
	public String print(LocalDate object, Locale locale) {
		return object.toString();
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		
		return LocalDate.parse(text);
	}

}
