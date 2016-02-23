package sii.maroc.Train;

import java.util.regex.Pattern;

import sii.maroc.Wagon.Wagons;
import sii.maroc.presentation.Trainformatter;

public class TrainColonFormatter implements Trainformatter {

    private static TrainColonFormatter INSTANCE = new TrainColonFormatter();
    private static String PipesLink = "||";
    private static String PipesColonLink = "|::|";
    private static String HPipeLink = "H|";
    private static String HColonPipeLink = "H::|";
    private static String PipeHLink = "|H";
    private static String PipeColonHLink = "|::H";
    private static String PipeArrowLink = "|<";
    private static String PipeColonArrowLink = "|::<";
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
	formattedTrain = unformattedTrain;
	formattedTrain = formattedTrain.replaceAll(Pattern.quote(PipeHLink), PipeColonHLink);
	formattedTrain = formattedTrain.replaceAll(Pattern.quote(PipeArrowLink), PipeColonArrowLink);
	formattedTrain = formattedTrain.replaceAll(Pattern.quote(HPipeLink), HColonPipeLink);
	formattedTrain = formattedTrain.replaceAll(Pattern.quote(PipesLink), PipesColonLink);
	return formattedTrain;
    }
}
