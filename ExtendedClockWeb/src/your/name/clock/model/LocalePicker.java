package your.name.clock.model;

import java.util.Locale;

public class LocalePicker {

public static Locale getLocaleFor(String locName) throws SetLocaleException {
		if (locName == null) {
			throw new SetLocaleException("No locale specified");
		}
		switch (locName.toUpperCase() ) {
		case "QUEBEC": {
			return Locale.CANADA_FRENCH;
		}
		case "FRANCE": {
			return Locale.FRANCE;
		}
		case "GERMANY": {
			return Locale.GERMANY;
		}
		case "JAPAN": {
			return Locale.JAPAN;
		}
		case "USA": {
			return Locale.US;
		}
		default: {
			throw new SetLocaleException("Locale for " + locName + " not recognized");
		}
		}
	}

}
