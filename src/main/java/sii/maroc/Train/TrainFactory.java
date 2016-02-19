package sii.maroc.Train;

import java.util.ArrayList;
import java.util.List;

import sii.maroc.Wagon.Wagon;

public class TrainFactory {

    private static TrainFactory INSTANCE = new TrainFactory();

    private TrainFactory() {
    }

    public static TrainFactory getInstance() {
	return INSTANCE;
    }

    public List<Wagon> createTrain(String trainType) {
	final List<Wagon> train = allocateWagonsToTrain(trainType);
	return train;
    }

    private List<Wagon> allocateWagonsToTrain(String trainType) {

	final String headlessType = removeTrainHeads(trainType);

	List<Wagon> resultTrain = creatHeadlessTrain(headlessType);

	if (trainHasHeadEnd(trainType)) {
	    resultTrain = addHeadToTheEndOf(resultTrain);
	}
	if (trainHasHeadStart(trainType)) {
	    resultTrain = addHeadToTheStartOf(resultTrain);
	}

	return resultTrain;
    }

    private List<Wagon> addHeadToTheStartOf(final List<Wagon> train) {
	final Wagon start = new Wagon("H");
	train.add(0, start);
	final List<Wagon> resultTrain = train;
	return resultTrain;
    }

    private boolean trainHasHeadStart(String trainType) {
	return trainType.startsWith("H");
    }

    private String removeTrainHeads(String trainType) {
	final String resultType = trainType.replaceAll("H", "");
	return resultType;
    }

    private List<Wagon> creatHeadlessTrain(String type) {
	List<Wagon> result = new ArrayList<Wagon>();
	for (int i = 0; i < type.length(); i++) {
	    final Wagon wagon = new Wagon(type.charAt(i) + "");
	    result.add(wagon);
	}
	return result;
    }

    private Boolean trainHasHeadEnd(String trainType) {
	return trainType.endsWith("H");
    }

    private List<Wagon> addHeadToTheEndOf(List<Wagon> train) {
	Wagon end = new Wagon("Head_End");
	final List<Wagon> resltTrain = train;
	resltTrain.add(end);
	return resltTrain;
    }

    public List<Wagon> linkWagons(String type) {
	final List<Wagon> train = allocateWagonsToTrain(type);
	return train;
    }

}
