package io.witlox.utils

object Smiley {

  private val positiveSmileys = List(":‑)", ":)", ":-]", ":]", ":-3", ":3", ":->", ":>", "8-)", "8)", ":-}",
    ":}", ":o)", ":c)", ":^)", "=]", "=)", ":-))", ":‑D", ":D", "8‑D", "8D", "x‑D", "xD", "X‑D",
    "XD", "=D", "=3", "B^D", ":'‑)", ":'))" ,";‑)", ";)", "*-)", "*)", ";‑]", ";]", ";^)", ":‑,", ";D",
    ":-*", ":*", ":×", "O:‑)", "O:)", "0:‑3", "0:3", "0:‑)", "0:)", "0;^)", ">:‑)", ">:)", "}:‑)", "}:)",
    "3:‑)", "3:)", ">;)", "|;‑)", ":‑J", "#‑)", "%‑)", "%)", "5:‑)", "*<|:‑)", ",:‑)", "<3", "\\o/", "*\\0/*",
    "^5", "o/\\o", ">_>^ ^<_<", "(^_-)", "(^_-)-*", "^_^", "(^_^)/", "(^O^)／", "(^o^)／", "(^^)/", "(·w·)",
    "^w^", "^m^", ">^_^<", "<^!^>", "^/^", "(*^_^*)", "§^.^§", "(^<^)", "(^.^)", "(^·^)", "(^.^)", "(^_^.)",
    "(^_^)", "(^^)", "(^J^)", "(*^.^*)", "^_^", "(#^.^#)", "(^—^)", "＼(~o~)／", "＼(^o^)／", "＼(-o-)／",
    "(*^0^*)", "(*_*)", "(*_*;", "(+_+)", "(@_@)", "(@_@。", "(@_@;)", "(*^^)v", "(^^)v", "(^_^)v", "(’-’*)",
    "( ^)o(^ )", "(^O^)", "(^o^)", "(^○^)", ")^o^("
  )
  private val negativeSmileys = List(":‑(", ":(", ":‑c", ":c", ":‑<", ":<", ":‑[", ":[", ":-||", ">:[", ":{", ":@", ">:(",
    ":'‑(", ":'(", "D‑':", "D:<", "D:", "D8", "D;", "D=", "DX", ":‑O", ":O", ":‑o", ":o", ":-0", "8‑0", ">:O",
    ":‑/", ":/", ":‑.", ">:\\", ">:/", ":\\", "=/", "=\\", ":L", "=L", ":S", ":$", ":‑X", ":X", ":‑#", ":#", ":‑&",
    ":&", ":‑###..", ":###..", "<:‑|", "~:‑\\", "</3", "<\\3", "><>", "<*)))‑{", "v.v", "O_O", "o‑o", "O_o", "o_O",
    "o_o", "O-O", ">.<", "(>_<)", "(>_<)>", "(^_^;)", "(-_-;)", "(~_~;)", "^_^;", "(#^.^#)", "(^^;)", "((+_+))",
    "(+o+)", "('_')", "(/_;)", "(T_T)", "(;_;)", "(;_;", "(;_:)", "(;O;)", "(:_;)", "(ToT)", ";_;", ";-;",
    ";n;", ";;", "Q.Q", "T.T", "QQ", "Q_Q", "(-.-)", "(-_-)", "(..)", "(._.)", "(..?", "(?_?)", "(-\"-)", "(^_^x)",
    "(-_-x)", "(~_~x)", "(--x)", "(0^0)", "(T_T)/~~~", "(ToT)/~~~", "(;_;)/~~~"
  )
  private val neutralSmileys = List(":‑P", ":P", "X‑P", "XP", "x‑p", "xp", ":‑p", ":p", ":‑Þ", ":Þ", ":‑þ", ":þ", ":‑b",
    ":b", "d:", "=p", ">:P", ":‑|", ":|", "|‑O", "~(_8^(I)", "=:o]", "7:^]", "@};-", "@}->--", "@}‑;‑'‑‑‑", "@>‑‑>‑‑",
    "><(((*>", "//0‑0\\\\", "(';')", "(^.^)y-.o○", "(-.-)y", "(-_-)zzz", "(o|o)", "<(｀^´)>", "(__)", "_(._.)_",
    "_(_^_)_", "<(_ _)>", "<m(__)m>", "m(__)m", "m(_ _)m", "(=_=)", "(=^·^=)", "(=^··^=)", "=_^=", "(^^)/~~~",
    "(^_^)/~", "(^.^)/~~~", "(-_-)/~~~", "($··)/~~~", "(@^^)/~~~", "!(^^)!", "(~o~)", "(~_~)","(p_-)", "((d[-_-]b))",
    "(^0_0^)", ":O o_O", "o_0", "o.O", "(o.o)", "oO"
  )

  def isSmiley(word: String): Boolean = negativeSmileys.contains(word) || positiveSmileys.contains(word) || neutralSmileys.contains(word)

  def isPositive(word: String): Boolean = positiveSmileys.contains(word)

  def isNegative(word: String): Boolean = negativeSmileys.contains(word)

  def isNeutral(word: String): Boolean = neutralSmileys.contains(word)
}