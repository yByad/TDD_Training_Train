package sii.maroc.Wagon;

import java.util.ArrayList;
import java.util.List;

class TrainFactory {

    private WagonFactory wagonFactory;
    private List<Wagon> resultTrain;

    public TrainFactory() {
	resultTrain = new ArrayList<Wagon>();
	wagonFactory = WagonFactory.getInstance();
    }

    List<Wagon> createTrain(String trainType) {
	trainType = trainType.replaceAll("H$", "E");
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
