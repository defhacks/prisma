package com.puzzletimer.tips;

import static com.puzzletimer.Internationalization.__;

import com.puzzletimer.models.Scramble;
import com.puzzletimer.solvers.RubiksCubeCrossSolver;
import com.puzzletimer.solvers.RubiksCubeSolver.State;
import com.puzzletimer.util.StringUtils;

public class RubiksCubeOptimalCross implements Tip {
    private static State x;
    private static State z;

    static {
        x = new State(
            new byte[] { 3, 2, 6, 7, 0, 1, 5, 4 },
            new byte[] { 2, 1, 2, 1, 1, 2, 1, 2 },
            new byte[] { 7, 5, 9, 11, 6, 2, 10, 3, 4, 1, 8, 0 },
            new byte[] { 0, 0, 0,  0, 1, 0,  1, 0, 1, 0, 1, 0 });

        z = new State(
            new byte[] { 4, 0, 3, 7, 5, 1, 2, 6 },
            new byte[] { 1, 2, 1, 2, 2, 1, 2, 1 },
            new byte[] { 8, 4, 6, 10, 0, 7, 3, 11, 1, 5, 2, 9 },
            new byte[] { 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1 });
    }

    @Override
    public String getTipId() {
        return "RUBIKS-CUBE-OPTIMAL-CROSS";
    }

    @Override
    public String getPuzzleId() {
        return "RUBIKS-CUBE";
    }

    @Override
    public String getTipDescription() {
        return __("tip.RUBIKS-CUBE-OPTIMAL-CROSS");
    }

    @Override
    public String getTip(Scramble scramble) {
        State state = State.id.applySequence(scramble.getSequence());

        StringBuilder tip = new StringBuilder();

        // cross on U
        State stateU =
            x.multiply(x).multiply(state).multiply(x).multiply(x);
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_u")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateU)) {
            tip.append("  x2 ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        // cross on D
        State stateD = state;
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_d")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateD)) {
            tip.append("  ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        // cross on L
        State stateL =
            z.multiply(state).multiply(z).multiply(z).multiply(z);
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_l")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateL)) {
            tip.append("  z' ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        // cross on R
        State stateR =
            z.multiply(z).multiply(z).multiply(state).multiply(z);
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_r")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateR)) {
            tip.append("  z ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        // cross on F
        State stateF =
            x.multiply(state).multiply(x).multiply(x).multiply(x);
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_f")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateF)) {
            tip.append("  x' ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        // cross on B
        State stateB =
            x.multiply(x).multiply(x).multiply(state).multiply(x);
        tip.append(__("tip.RUBIKS-CUBE-OPTIMAL-CROSS.optimal_cross_on_b")).append(":\n");
        for (String[] solution : RubiksCubeCrossSolver.solve(stateB)) {
            tip.append("  x ").append(StringUtils.join(" ", solution)).append("\n");
        }
        tip.append("\n");

        return tip.toString().trim();
    }

    @Override
    public String toString() {
        return getTipDescription();
    }
}
