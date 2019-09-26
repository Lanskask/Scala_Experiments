package codewars;

public class KataFighter {

//      public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
//        Fighter a=fighter1, b=fighter2;
//        if (firstAttacker.equals(fighter2.name)) {
//          a = fighter2; b = fighter1;
//        }
//        while (true) {
//          if ((b.health -= a.damagePerAttack) <= 0) return a.name;  // a wins
//          if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
//        }
//      }
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter answFighter = null, frstFighter = null, scndFighter = null;

        if(fighter1.name.equals(firstAttacker)) {
            frstFighter = fighter1;
            scndFighter = fighter2;
        } else {
            frstFighter = fighter2;
            scndFighter = fighter1;
        }

        while(frstFighter.health > 0 && scndFighter.health > 0) {
            scndFighter.health -= frstFighter.damagePerAttack;
            if (scndFighter.health <= 0) {
                answFighter = frstFighter;
                return frstFighter.name;
            }
            frstFighter.health -= scndFighter.damagePerAttack;
            if (frstFighter.health <= 0) {
                answFighter = scndFighter;
                return scndFighter.name;
            }
        }
        return answFighter.name;
    }

}
