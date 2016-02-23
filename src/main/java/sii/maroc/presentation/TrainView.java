package sii.maroc.presentation;

import sii.maroc.Types.WagonTypes;

public interface TrainView {

    Object getView();

    void setPresentation(Object unformattedTrain);

    String getPresentationOf(WagonTypes type);

}
