package com.slidingpuzzlesolver.elkadakh.sliding_puzzle_solver;

public class InputException extends Exception {
    ProblemIdentifier prob;

    InputException(ProblemIdentifier prob){
        this.prob = prob;
    }
}
