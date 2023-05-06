package sopt.org.firstSeminarAdvancedAssignment.controller;

import sopt.org.firstSeminarAdvancedAssignment.view.InputView;
import sopt.org.firstSeminarAdvancedAssignment.view.OutputView;

public abstract class Controller {

    protected InputView inputView;
    protected OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}

