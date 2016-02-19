package sii.maroc.Train;

import java.util.List;
import java.util.regex.Pattern;

import sii.maroc.Wagon.Wagon;
import sii.maroc.presentation.Trainformatter;

public class TrainColonFormatter implements Trainformatter {

    private static TrainColonFormatter INSTANCE = new TrainColonFormatter();

    private TrainColonFormatter() {
    }

    public static TrainColonFormatter getInstance() {
	return INSTANCE;
    }

    public String format(List<Wagon> wagons) {
	String formattedTrain = "";
	for (int i = 0; i < wagons.size(); i++) {
	    formattedTrain += wagons.get(i).retrieveWagonFormat();
	}
	formattedTrain = formatTrain(formattedTrain);
	return formattedTrain;
    }

    private String formatTrain(final String resultTrain) {

	final String formattedTrain = resultTrain.replaceAll(Pattern.quote("||"), "|::|");
	return formattedTrain;
    }
}
