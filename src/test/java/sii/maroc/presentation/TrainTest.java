package sii.maroc.presentation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TrainTest {

    @Test
    public void passengerTrain() {
	Train train = new Train("HPP");
	assertEquals("<HHHH::|OOOO|::|OOOO|", train.print());
    }

    @Test
    public void restaurantTrain() {
	Train train = new Train("HPRP");
	assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
    }

    @Test
    public void fullyMixedTrain() {
	Train train = new Train("HPHRHPH");
	assertEquals("<HHHH::|OOOO|::<HHHH::|hThT|::<HHHH::|OOOO|::HHHH>", train.print());
    }

    @Test
    public void doubleHeadedTrain() {
	Train train = new Train("HPRPH");
	assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|::HHHH>", train.print());
    }

    @Test
    public void doubleHeadedCargoTrainCreation() {
	Train train = new Train("CCCH");
	assertEquals("|____|::|____|::|____|::HHHH>", train.print());
    }

    @Test
    public void mixedTrainCreation() {
	Train train = new Train("HPCPC");
	assertEquals("<HHHH::|OOOO|::|____|::|OOOO|::|____|", train.print());
    }

    @Test
    public void NonExistingWagon() {
	Train train = new Train("TBVXZ");
	assertEquals("|%%%%|::|%%%%|::|%%%%|::|%%%%|::|%%%%|", train.print());
    }

    @Test
    public void modifyTrain() {
	Train train = new Train("HPRPH");
	train.detachEnd();
	assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
	train.detachHead();
	assertEquals("|OOOO|::|hThT|::|OOOO|", train.print());
	train.detachEnd();
	assertEquals("|OOOO|::|hThT|", train.print());
	train.detachEnd();
	assertEquals("|OOOO|", train.print());
	train.detachEnd();
	assertEquals("|OOOO|", train.print());
    }

    @Test
    public void cargoTrain() {
	Train train = new Train("HCCC");
	assertEquals("<HHHH::|____|::|____|::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|^^^^|::|____|::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|^^^^|::|^^^^|::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|^^^^|::|^^^^|::|^^^^|", train.print());
	assertFalse(train.fill());
    }

    @Test
    public void mixedTrain() {
	Train train = new Train("HPCPC");
	assertEquals("<HHHH::|OOOO|::|____|::|OOOO|::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|^^^^|", train.print());
	assertFalse(train.fill());
    }

    @Test
    public void attachWagonToExistingTrain() {
	Train train = new Train("HPHRHPH");
	assertEquals("<HHHH::|OOOO|::<HHHH::|hThT|::<HHHH::|OOOO|::HHHH>", train.print());
	train.attachEnd("C");
	assertEquals("<HHHH::|OOOO|::<HHHH::|hThT|::<HHHH::|OOOO|::HHHH>::|____|", train.print());
	train.fill();
	assertEquals("<HHHH::|OOOO|::<HHHH::|hThT|::<HHHH::|OOOO|::HHHH>::|^^^^|", train.print());
    }

    @Test
    public void modifyAndFillTrain() {
	Train train = new Train("HCRCH");
	train.detachEnd();
	assertEquals("<HHHH::|____|::|hThT|::|____|", train.print());
	train.detachHead();
	train.fill();
	assertEquals("|^^^^|::|hThT|::|____|", train.print());
	train.detachEnd();
	train.fill();
	assertEquals("|^^^^|::|hThT|", train.print());
	train.detachEnd();
	assertEquals("|^^^^|", train.print());
	train.detachEnd();
	assertEquals("|^^^^|", train.print());
    }

}
