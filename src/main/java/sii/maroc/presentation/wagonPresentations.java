package sii.maroc.presentation;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import sii.maroc.Wagon.WagonTypes;

public class wagonPresentations {

    private static Map<WagonTypes, Presentations> wagonPresentations = new HashMap<WagonTypes, Presentations>();

    private void initializeWagonPresentations() {
	for (WagonTypes types : EnumSet.allOf(WagonTypes.class)) {
	    final String presentationName = types.name();
	    wagonPresentations.put(types, ColonPresentations.valueOf(presentationName));
	}
    }

    public wagonPresentations() {
	initializeWagonPresentations();
    }

    public String getPresentation(WagonTypes type) {
	final ColonPresentations wagonPresentation = (ColonPresentations) wagonPresentations.get(type);
	final String presentation = wagonPresentation.value();
	return presentation;
    }

}
