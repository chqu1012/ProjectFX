package de.dc.projectfx.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;

@Controller
public class MainController extends BaseMainBindingController{

	@Override
	protected void onButtonAction(ActionEvent event) {
		Object source = event.getSource();
		if (source == buttonSetStart) {
			model.setStart(LocalTime.now());
		}else if (source == buttonSetEnd) {
			model.setEnd(LocalTime.now());
		}
	}
}
