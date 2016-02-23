package sii.maroc.presentation;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import sii.maroc.Wagon.WagonTypes;

public class TrainViewColon {

    private static Map<WagonTypes, Presentations> wagonPresentations = new HashMap<WagonTypes, Presentations>();

    private String trainPresentation;

    public TrainViewColon() {
	initializeWagonPresentations();
    }

    private static void initializeWagonPresentations() {
	for (WagonTypes types : EnumSet.allOf(WagonTypes.class)) {
	    final String presentationName = types.name();
	    wagonPresentations.put(types, ColonPresentations.valueOf(presentationName));
	}
    }

    public String getView() {
	addLinkers();
	return trainPresentation;
    }

    private void addLinkers() {
	trainPresentation = trainPresentation.replaceAll(Pattern.quote("|H"), "|::H");
	trainPresentation = trainPresentation.replaceAll(Pattern.quote("|<"), "|::<");
	trainPresentation = trainPresentation.replaceAll(Pattern.quote(">|"), ">::|");
	trainPresentation = trainPresentation.replaceAll(Pattern.quote("H|"), "H::|");
	trainPresentation = trainPresentation.replaceAll(Pattern.quote("||"), "|::|");
    }

    public String getPresentationOf(WagonTypes type) {
	final ColonPresentations wagonPresentation = (ColonPresentations) wagonPresentations.get(type);
	final String presentation = wagonPresentation.value();
	return presentation;
    }

    public void setPresentation(String unformattedTrain) {
	this.trainPresentation = unformattedTrain;
    }
}
