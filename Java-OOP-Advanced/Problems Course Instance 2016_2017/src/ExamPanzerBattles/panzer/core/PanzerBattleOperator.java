package ExamPanzerBattles.panzer.core;

import ExamPanzerBattles.panzer.contracts.BattleOperator;
import ExamPanzerBattles.panzer.contracts.Vehicle;

public class PanzerBattleOperator implements BattleOperator {

    @Override
    public String battle(Vehicle attacker, Vehicle target) {

        double attackerWeight = attacker.getTotalWeight();
        long attackerAttack = attacker.getTotalAttack();
        long attackerDefense = attacker.getTotalDefense();
        long attackerHitPoints = attacker.getTotalHitPoints();

        double targetWeight = target.getTotalWeight();
        long targetAttack = target.getTotalAttack();
        long targetDefense = target.getTotalDefense();
        long targetHitPoints = target.getTotalHitPoints();

        boolean isAttackerTurn = true;
        boolean isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);

        while (!isSomeoneDead) {
            if (isAttackerTurn) {
                targetHitPoints -= Math.max(0, (long) Math.ceil(attackerAttack - (targetDefense + (targetWeight / 2.0))));
                isAttackerTurn = false;
            } else {
                attackerHitPoints -= Math.max(0, (long) Math.ceil(targetAttack - (attackerDefense + (attackerWeight / 2.0))));
                isAttackerTurn = true;
            }

            isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);
        }

        return isDead(attackerHitPoints) ? target.getModel() : attacker.getModel();
    }

    private boolean isDead(long hitPoints) {
        return hitPoints <= 0L;
    }
}
