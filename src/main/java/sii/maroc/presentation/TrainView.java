package sii.maroc.presentation;

public interface TrainView {

    Object getView();

    void setPresentation(Object unformattedTrain);

    String getPresentationOf(WagonTypes type);

}
