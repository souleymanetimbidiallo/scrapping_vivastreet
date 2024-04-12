package library

object Analyser extends AnalysePage {
  def resultats(url:String,exp:Expression):List[(String,String)] = {
    List(("Irisa - Laboratoire de recherche à Beaulieu", "http://www.irisa.fr"),
        ("Istic - UFR d'Informatique électronique de Rennes", "http://www.istic.univ-rennes1.fr"),
        ("Google - Moteur de Recherche", "http://www.google.fr"),
        ("Share - Plateforme de partage de document", "http://share-etu.istic.univ-rennes1.fr"))
  }
}

object AnalyserURL extends FiltrageURLs {
  
  val tools = UrlProcessor
  
  def filtreAnnonce(h:Html):List[String]={
    h match {
      case Text(_) => List()
      case Tag("a",List(url),_)  if(tools.host(url._2) == "https://www.vivastreet.com/") =>  List(url._2)
      case Tag(_,_,hn) => filtreAux(hn)
    }
  }
  private def filtreAux(h:List[Html]):List[String]={
    h match {
      case Nil => Nil
      case a::r => filtreAnnonce(a)++filtreAux(r)
    }
  }
}
