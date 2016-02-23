package sii.maroc.Train;

import java.util.regex.Pattern;

import sii.maroc.Wagon.Wagons;
import sii.maroc.presentation.Trainformatter;

public class TrainColonFormatter implements Trainformatter {

    private static TrainColonFormatter INSTANCE = new TrainColonFormatter();
    private static String oldLink = "||";
    private static String newLink = "|::|";
    private String formattedTrain;

    private TrainColonFormatter() {

    }

    public static TrainColonFormatter getInstance() {
	return INSTANCE;
    }

    @Override
    public String format(Wagons wagons) {

	final String unformattedTrain = wagons.getWagonsPresentation();

	formattedTrain = formatTrain(unformattedTrain);
	return formattedTrain;
    }

    private String formatTrain(final String unformattedTrain) {

	formattedTrain = unformattedTrain.replaceAll(Pattern.quote(oldLink), newLink);
	return formattedTrain;
    }
}
