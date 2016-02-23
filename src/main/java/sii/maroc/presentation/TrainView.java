package sii.maroc.presentation;

import sii.maroc.Types.WagonTypes;

public interface TrainView {

    String getView();

    void getPresentationOf(WagonTypes type);

}
