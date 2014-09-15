package simulationObjects;

import java.util.ArrayList;

public class ForestCell extends Cell {

    public enum State {
	EMPTY, TREE, ONFIRE
    }

    public ForestCell() {

    }

    @Override
    public void update(ArrayList<Cell> neighbors) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean prepareToUpdate(int myState,ArrayList<Cell> neighbors) {
	return false;

    }

    @Override
    public int getState() {
	return myState;
    }

    @Override
    public void setState(int state) {
	myState = state;
    }

}
