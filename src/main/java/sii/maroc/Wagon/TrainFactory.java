package sii.maroc.Wagon;

import java.util.ArrayList;
import java.util.List;

public class TrainFactory {

    private static TrainFactory INSTANCE = new TrainFactory();
    private WagonFactory wagonFactory;
    private List<Wagon> resultTrain;

    private TrainFactory() {
	resultTrain = new ArrayList<Wagon>();
	wagonFactory = WagonFactory.getInstance();
    }

    public static TrainFactory getInstance() {
	return INSTANCE;
    }

    public List<Wagon> createTrain(String trainType) {
	trainType = trainType.replaceAll("H$", "E");
	resultTrain.clear();
	attachWagonsToTrain(trainType);
	return resultTrain;
    }

    private void attachWagonsToTrain(String trainType) {
	for (int i = 0; i < trainType.length(); i++) {
	    final Wagon wagon = wagonFactory.createWagon(trainType.charAt(i) + "");
	    resultTrain.add(wagon);
	}
    }

}
