/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livematch;

import controller.WindowController;

/**
 *
 * @author Dennis
 */
public class LiveMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //new TestView1();
        // TODO code application logic here
        /*SummonerApi summApi = new SummonerApi(Region.EUNE);
         SummonerAPI summ = summApi.getSummonerByName("Bell Ciel");
        
         ChampionApi champApi = new ChampionApi(Region.EUNE);
        
         Champion champ = champApi.getChampionById(51);
        
         System.out.println("ID: "+summ.getId());
         System.out.println("Name: "+champ.getName());
        
         LiveMatchApi matchApi = new LiveMatchApi(Region.EUNE);
         LiveMatch m = matchApi.getMatchBySummonerName("Bell Ciel");
        
         System.out.println(m);*/
        WindowController windowController = new WindowController();
        windowController.control();
        ///new TestView1();
        //launch(args);
        /*Api api = new Api();
         ArrayList<Integer> ids = new ArrayList<>();
         ids.add(28734375);

         Map<String, SummonerAPI> summoners = api.getSummonerBySummonerIds(ids, Region.EUNE);

         Iterator it = summoners.entrySet().iterator();
        
         while (it.hasNext()) {
         Map.Entry pair = (Map.Entry) it.next();
         String key = String.valueOf(pair.getKey());
         SummonerAPI summoner = (SummonerAPI) pair.getValue();
         System.out.println(pair.getKey());
         System.out.println(summoner.getName());
         it.remove(); // avoids a ConcurrentModificationException
         }
         ArrayList<String> names = new ArrayList<>();
         names.add("Invicz");
         names.add("vAlexHU");

         Map<String, SummonerAPI> summoners1 = api.getSummonerBySummonerNames(names, Region.EUNE);

         int summonerId = summoners1.get("valexhu").getId();
         System.out.println("SUMMONER ID: " + summonerId);

         CurrentGameAPI currentGame = api.getCurrentGameBySummonerId(summonerId, Region.EUNE);

         System.out.println(currentGame.getGameMode());

         for (BannedChampionAPI champion : currentGame.getBannedChampions()) {
         System.out.println(champion.getChampionId());
         }

         ArrayList<Integer> summIds = new ArrayList<>();
        
         LiveMatch match = new LiveMatch();

         for (ParticipantAPI summoner : currentGame.getParticipants()) {
         System.out.println(summoner.getSummonerName() + " " + summoner.getTeamId());
         SummonerSpellAPI spell1 = api.getSummonerSpellById((int) summoner.getSpell1Id(), Region.EUNE);
         SummonerSpellAPI spell2 = api.getSummonerSpellById((int) summoner.getSpell2Id(), Region.EUNE);

         summIds.add((int) summoner.getSummonerId());
         }

         Map<String, ArrayList<LeagueAPI>> leagueAPI = api.getLeagueBySummonerIds(summIds, Region.EUNE);

         Iterator it = leagueAPI.entrySet().iterator();

         while (it.hasNext()) {
         Map.Entry pair = (Map.Entry) it.next();
         String key = String.valueOf(pair.getKey());
         ArrayList<LeagueAPI> league = (ArrayList<LeagueAPI>) pair.getValue();
         System.out.println(pair.getKey());
         System.out.println("TIER "+league.get(0).getTier());
         it.remove(); // avoids a ConcurrentModificationException
         }*/

    }

}
