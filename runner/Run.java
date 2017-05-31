package runner;

import IG.JFrameViewPeople;
import controller.Controller;
import percistence.Load;

public class Run{

	public static void main(String[] args) {
		JFrameViewPeople jframeViewPeople = new JFrameViewPeople(new Load().loadCity());
		Controller controller = new Controller(jframeViewPeople);
	}
}
