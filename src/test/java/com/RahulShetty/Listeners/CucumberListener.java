package com.RahulShetty.Listeners;

import com.RahulShetty.Reports.ExtentManager;
import com.aventstack.extentreports.Status;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;

public class CucumberListener implements ConcurrentEventListener {
	@Override
	public void setEventPublisher(EventPublisher publisher) {

		publisher.registerHandlerFor(TestStepFinished.class, event -> {

			if (event.getResult().getStatus().name().equals("FAILED")) {

				Throwable error = event.getResult().getError();

				if (error != null) {
					ExtentManager.getTest().log(Status.FAIL, error);
				}
			}
		});
	}
}
