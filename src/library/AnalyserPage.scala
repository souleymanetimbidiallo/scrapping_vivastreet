package library

object AnalyserPage extends AnalysePage {
/** A partir d'une URL de requête sur le site de référence et d'une expression exp, 
    retourne de pages issues de la requête et satisfaisant l'expression.

    @param url l'URL de la requête sur le site de référence 
    @param exp l'expression à vérifier sur les pages trouvées
    @return la liste des couples (titre,ref) où ref est l'URL d'une page
            satisfaisant l'expression et titre est son titre. */
  def resultats(url:String,exp:Expression):List[(String,String)]= ???
  
}