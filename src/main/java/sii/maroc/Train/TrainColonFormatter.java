package sii.maroc.Train;

import java.util.List;
import java.util.regex.Pattern;

import sii.maroc.Wagon.Wagon;
import sii.maroc.presentation.Trainformatter;

public class TrainColonFormatter implements Trainformatter {

    private static TrainColonFormatter INSTANCE = new TrainColonFormatter();
    private String formattedTrain;

    private TrainColonFormatter() {

    }

    public static TrainColonFormatter getInstance() {
	return INSTANCE;
    }

    public String format(List<Wagon> wagons) {
	formattedTrain = "";
	for (int i = 0; i < wagons.size(); i++) {
	    formattedTrain += wagons.get(i).retrieveWagonFormat();
	}
	formattedTrain = formatTrain();
	return formattedTrain;
    }

    private String formatTrain() {

	formattedTrain = formattedTrain.replaceAll(Pattern.quote("||"), "|::|");
	return formattedTrain;
    }
}
