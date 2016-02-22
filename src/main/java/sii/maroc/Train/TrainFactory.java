package sii.maroc.Train;

import java.util.ArrayList;
import java.util.List;

import sii.maroc.Wagon.Wagon;
import sii.maroc.Wagon.WagonFactory;

public class TrainFactory {

    private static TrainFactory INSTANCE = new TrainFactory();
    private WagonFactory factory;
    private List<Wagon> resultTrain;

    private TrainFactory() {
	resultTrain = new ArrayList<Wagon>();
	factory = WagonFactory.getInstance();
    }

    public static TrainFactory getInstance() {
	return INSTANCE;
    }

    public List<Wagon> createTrain(String trainType) {

	resultTrain.clear();
	allocateWagonsToTrain(trainType);
	return resultTrain;
    }

    private void allocateWagonsToTrain(String trainType) {

	final String headlessType = removeTrainHeads(trainType);

	creatHeadlessTrain(headlessType);

	addHeadsToTrain(trainType);

    }

    private String removeTrainHeads(String trainType) {
	final String resultType = trainType.replaceAll("H", "");
	return resultType;
    }

    private void creatHeadlessTrain(String type) {
	for (int i = 0; i < type.length(); i++) {
	    final Wagon wagon = factory.createWagon(type.charAt(i) + "");
	    resultTrain.add(wagon);
	}
    }

    private void addHeadsToTrain(String trainType) {
	if (trainHasHeadStart(trainType)) {
	    addHeadToTheStartOf();
	}
	if (trainHasHeadEnd(trainType)) {
	    addHeadToTheEndOf();
	}

    }

    private boolean trainHasHeadStart(String trainType) {
	return trainType.startsWith("H");
    }

    private void addHeadToTheStartOf() {
	final Wagon start = factory.createWagon("H");
	final int trainHeadPosition = 0;
	resultTrain.add(trainHeadPosition, start);
    }

    private Boolean trainHasHeadEnd(String trainType) {
	return trainType.endsWith("H");
    }

    private void addHeadToTheEndOf() {
	Wagon end = factory.createWagon("Head_End");
	resultTrain.add(end);
    }

}
