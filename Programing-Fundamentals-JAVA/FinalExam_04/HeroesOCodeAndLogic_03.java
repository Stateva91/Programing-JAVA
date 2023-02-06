package FinalExam_04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOCodeAndLogic_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // geroi->hp
        Map<String, Integer> heroesHp=new LinkedHashMap<>();
        // geroi->mp
        Map<String, Integer> heroesMp=new LinkedHashMap<>();
        int countHeroes=Integer.parseInt(scanner.nextLine());

        for (int hero = 1; hero <=countHeroes ; hero++) {
            String heroInfo= scanner.nextLine(); //{hero name} {HP} {MP}
            String[] heroData=heroInfo.split("\\s+");
            String heroName=heroData[0];
            int hp=Integer.parseInt(heroData[1]);
            int mp=Integer.parseInt(heroData[2]);
            if(hp<=100){
                // geroi->hp
                heroesHp.put(heroName, hp);
            }
            if(mp<=200){
                heroesMp.put(heroName, mp);
            }
        }
        String command= scanner.nextLine();
        while (!command.equals("End")){
            //1.CastSpell – {hero name} – {MP needed} – {spell name}
            if(command.contains("CastSpell")){
                String heroName=command.split("\\s+-\\s+")[1];
                int mpNeed=Integer.parseInt(command.split("\\s+-\\s+")[2]);
                String spellName=command.split("\\s+-\\s+")[3];

                int currentMp=heroesMp.get(heroName);
                if(currentMp>=mpNeed){
                    int mpLeft=currentMp-mpNeed; // ostanali tochki sled magiqta
                    heroesMp.put(heroName, mpLeft); // namalqme stoinostta na mp
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            }
            //2.TakeDamage – {hero name} – {damage} – {attacker}
            else if(command.contains("TakeDamage")){
                String heroName=command.split("\\s+-\\s+")[1];
                int damage=Integer.parseInt(command.split("\\s+-\\s+")[2]);
                String attacker=command.split("\\s+-\\s+")[3];
                int currentHp=heroesHp.get(heroName);
                currentHp-=damage;
                if(currentHp>0){  // jiv
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHp);
                    heroesHp.put(heroName, currentHp);
                } else {
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    heroesHp.remove(heroName);
                    heroesMp.remove(heroName);
                }
            }
            //3.Recharge – {hero name} – {amount}"
            else if(command.contains("Recharge")){
                String heroName=command.split("\\s+-\\s+")[1];
                int amount=Integer.parseInt(command.split("\\s+-\\s+")[2]);

                int currentMp=heroesMp.get(heroName);
                currentMp+=amount;
                if(currentMp>200){
                    currentMp=200;
                }
                System.out.printf("%s recharged for %d MP!%n", heroName, currentMp-heroesMp.get(heroName));
                heroesMp.put(heroName, currentMp);
            }
            //4.Heal – {hero name} – {amount}
            else if(command.contains("Heal")){
                String heroName=command.split("\\s+-\\s+")[1];
                int amountHp=Integer.parseInt(command.split("\\s+-\\s+")[2]);
                int currentHp=heroesHp.get(heroName);
                currentHp+=amountHp;
                if(currentHp>100){
                    currentHp=100;
                }
                System.out.printf("%s healed for %d HP!%n", heroName, currentHp-heroesHp.get(heroName));
                heroesHp.put(heroName, currentHp);
            }

            command= scanner.nextLine();
        }
        heroesHp.entrySet().forEach(entry->{
            String heroName= entry.getKey();
            System.out.println(heroName);
            System.out.println("  HP: "+ entry.getValue());
            System.out.println("  MP: "+ heroesMp.get(heroName));
        });
    }
}
