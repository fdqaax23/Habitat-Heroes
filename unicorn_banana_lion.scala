1. package habitatheroes

2. import scala.collection.mutable

3. object HabitatHeroes {

4.  val neighbourhood: mutable.Map[String, Int] = mutable.Map("Monk" -> 1, "Pegasus" -> 2, "Robot" -> 3, "Magician" -> 4)

5.  

6.  def addHero(heroName: String, neighbourhoodRank: Int): Unit = {

7.    neighbourhood += (heroName -> neighbourhoodRank)

8. }

9. 

10. def removeHero(heroName: String): Unit = {

11.   neighbourhood -= heroName

12. 

13. }

14. 

15. def getHeroRank(heroName: String): Int = {

16.   neighbourhood.get(heroName).get

17. 

18. }

19. 

20. def isHeroInNeighbourhood(heroName: String): Boolean = {

21.   neighbourhood.exists(_._1 == heroName)

22. 

23. }

24. 

25. def getHeroesInNeighbourhood: List[String] = {

26.   neighbourhood.keys.toList

27. 

28. }

29. 

30. def getHeroesWithRank(rank: Int): List[String] = {

31.   neighbourhood.filter(_._2 == rank).keys.toList

32. 

33. }

34. 

35. def getNumberOfHeroes: Int = neighbourhood.size

36. 

37. def isEmpty: Boolean = neighbourhood.isEmpty

38. 

39. def printHeroes: Unit = {

40.   neighbourhood.foreach(kv => println(s"${kv._1} is ranked ${kv._2}"))

41. }

42. 

43. }

44. 

45. object Main {

46.   def main(args: Array[String]): Unit = {

47.     HabitatHeroes.printHeroes

48.   }

49. 

50. }



51. package habitatheroes

52. 

53. class Hero(val name: String, val rank: Int)

54. 

55. object Hero {

56.   def apply(name: String, rank: Int): Hero = new Hero(name, rank)

57. 

58.   def fromString(s: String): Option[Hero] = {

59.     val tokens = s.split(",")

60.     tokens.length match {

61.       case 2 => Some(Hero(tokens(0), tokens(1).toInt))

62.       case _ => None

63.     }

64.   }

65. 

66.   def addHero(hero: Hero): Unit = {

67.     HabitatHeroes.addHero(hero.name, hero.rank)

68.   }

69. 

70.   def removeHero(heroName: String): Unit = {

71.     HabitatHeroes.removeHero(heroName)

72.   }

73. 

74.   def getHeroRank(heroName: String): Int = {

75.     HabitatHeroes.getHeroRank(heroName)

76.   }

77. 

78.   def isHeroInNeighbourhood(heroName: String): Boolean = {

79.     HabitatHeroes.isHeroInNeighbourhood(heroName)

80.   }

81. 

82.   def getHeroesWithRank(rank: Int): List[String] = {

83.     HabitatHeroes.getHeroesWithRank(rank)

84.   }

85. 

86.   def printHeroes: Unit = {

87.     HabitatHeroes.printHeroes

88.   }

89. 

90. }



91. package habitatheroes

92. 

93. trait Superhero {

94.   val power: String

95.   val origin: String

96. 

97.   def usePower: Unit

98. }

99. 

100. abstract class Creature extends Superhero {

101.   val power: String

102.   val origin: String

103. 

104.   def usePower: Unit

105. 

106.   def fly: Unit

107. 

108.   override def toString: String = s"power: $power, origin: $origin"

109. }

110. 

111. class Monk(override val power: String, override val origin: String) extends Creature {

112.   override def usePower: Unit = println(s"Using power of $power")

113. 

114.   override def fly: Unit = println("Monks can't fly!")

115. }

116. 

117. class Pegasus(override val power: String, override val origin: String) extends Creature {

118.   override def usePower: Unit = println(s"Using power of $power")

119. 

120.   override def fly: Unit = println("Pegasus can fly")

121. }

122. 

123. class Robot(override val power: String, override val origin: String) extends Superhero {

124.   override def usePower: Unit = println(s"Using power of $power")

125. }

126. 

127. class Magician(override val power: String, override val origin: String) extends Superhero {

128.   override def usePower: Unit = println(s"Using power of $power")

129. }

130. 

131. object SuperHeroFactory {

132.   def getHero(heroName: String, power: String, origin: String): Superhero = {

133.     heroName match {

134.       case "Monk" => new Monk(power, origin)

135.       case "Pegasus" => new Pegasus(power, origin)

136.       case "Robot" => new Robot(power, origin)

137.       case "Magician" => new Magician(power, origin)

138.     }

139.   }

140. }



141. package habitatheroes

142. 

143. import scala.io.Source

144. 

145. object TestHero extends App {

146.   val source = Source.fromFile("heroes.txt")

147.   val lines = source.getLines

148. 

149.   for (line <- lines) {

150.     Hero.fromString(line) match {

151.       case Some(h) => Hero.addHero(h)

152.       case None => println("Invalid hero line")

153.     }

154.   }

155. 

156.   val superman = SuperHeroFactory.getHero("Robot", "Super Strength", "Krypton")

157.   superman.usePower

158. }



159. package habitatheroes

160. 

161. object Game {

162.   def fight(hero1: Superhero, hero2: Superhero): Unit = {

163.     println(s"${hero1.getClass.getSimpleName} vs ${hero2.getClass.getSimpleName}")

164.     while (hero1.power == hero2.power) {

165.       hero1.usePower

166.       hero2.usePower

167.     }

168.   }

169. }