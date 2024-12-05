package GeneratedClasses;// Generated from /Users/josemendes/Documents/IdeaProjects/sem4pi-23-24-2dh2/JobRequirementsSpecification/src/main/java/JobRequirementsSpecification.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JobRequirementsSpecificationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TITLE=1, COMPANY=2, JOB=3, EMAIL=4, REQUIREMENT=5, NUMBERQ=6, MULTIPLEQ=7, 
		TEXTQ=8, ANSEWER=9, NUMBER=10, MULTIPLANSEWER=11, NEWLINE=12, DESCRIPTION=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TITLE", "COMPANY", "JOB", "EMAIL", "REQUIREMENT", "NUMBERQ", "MULTIPLEQ", 
			"TEXTQ", "ANSEWER", "NUMBER", "MULTIPLANSEWER", "NEWLINE", "DESCRIPTION"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE: '", "'COMPANY:'", "'ABOUT THIS JOB:'", "'EMAIL:'", "'REQUIREMENT '", 
			"'NUMBER QUESTION:'", "'MULTIPLE MULTIPLE-CHOICE QUESTION:'", "'TEXT QUESTION:'", 
			"'ANSWER:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TITLE", "COMPANY", "JOB", "EMAIL", "REQUIREMENT", "NUMBERQ", "MULTIPLEQ", 
			"TEXTQ", "ANSEWER", "NUMBER", "MULTIPLANSEWER", "NEWLINE", "DESCRIPTION"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JobRequirementsSpecificationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JobRequirementsSpecification.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r\u00af\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0004\t\u009d\b\t\u000b\t\f\t\u009e\u0001"+
		"\n\u0004\n\u00a2\b\n\u000b\n\f\n\u00a3\u0001\u000b\u0004\u000b\u00a7\b"+
		"\u000b\u000b\u000b\f\u000b\u00a8\u0001\f\u0004\f\u00ac\b\f\u000b\f\f\f"+
		"\u00ad\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u0001\u0000\u0004\u0002\u0000  09\u0004\u0000  )),,ad\u0002\u0000"+
		"\n\n\r\r\u0006\u0000  ##(,..?Zaz\u00b2\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b"+
		"\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005,\u0001\u0000"+
		"\u0000\u0000\u0007<\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000"+
		"\u000bP\u0001\u0000\u0000\u0000\ra\u0001\u0000\u0000\u0000\u000f\u0084"+
		"\u0001\u0000\u0000\u0000\u0011\u0093\u0001\u0000\u0000\u0000\u0013\u009c"+
		"\u0001\u0000\u0000\u0000\u0015\u00a1\u0001\u0000\u0000\u0000\u0017\u00a6"+
		"\u0001\u0000\u0000\u0000\u0019\u00ab\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0005T\u0000\u0000\u001c\u001d\u0005I\u0000\u0000\u001d\u001e\u0005T"+
		"\u0000\u0000\u001e\u001f\u0005L\u0000\u0000\u001f \u0005E\u0000\u0000"+
		" !\u0005:\u0000\u0000!\"\u0005 \u0000\u0000\"\u0002\u0001\u0000\u0000"+
		"\u0000#$\u0005C\u0000\u0000$%\u0005O\u0000\u0000%&\u0005M\u0000\u0000"+
		"&\'\u0005P\u0000\u0000\'(\u0005A\u0000\u0000()\u0005N\u0000\u0000)*\u0005"+
		"Y\u0000\u0000*+\u0005:\u0000\u0000+\u0004\u0001\u0000\u0000\u0000,-\u0005"+
		"A\u0000\u0000-.\u0005B\u0000\u0000./\u0005O\u0000\u0000/0\u0005U\u0000"+
		"\u000001\u0005T\u0000\u000012\u0005 \u0000\u000023\u0005T\u0000\u0000"+
		"34\u0005H\u0000\u000045\u0005I\u0000\u000056\u0005S\u0000\u000067\u0005"+
		" \u0000\u000078\u0005J\u0000\u000089\u0005O\u0000\u00009:\u0005B\u0000"+
		"\u0000:;\u0005:\u0000\u0000;\u0006\u0001\u0000\u0000\u0000<=\u0005E\u0000"+
		"\u0000=>\u0005M\u0000\u0000>?\u0005A\u0000\u0000?@\u0005I\u0000\u0000"+
		"@A\u0005L\u0000\u0000AB\u0005:\u0000\u0000B\b\u0001\u0000\u0000\u0000"+
		"CD\u0005R\u0000\u0000DE\u0005E\u0000\u0000EF\u0005Q\u0000\u0000FG\u0005"+
		"U\u0000\u0000GH\u0005I\u0000\u0000HI\u0005R\u0000\u0000IJ\u0005E\u0000"+
		"\u0000JK\u0005M\u0000\u0000KL\u0005E\u0000\u0000LM\u0005N\u0000\u0000"+
		"MN\u0005T\u0000\u0000NO\u0005 \u0000\u0000O\n\u0001\u0000\u0000\u0000"+
		"PQ\u0005N\u0000\u0000QR\u0005U\u0000\u0000RS\u0005M\u0000\u0000ST\u0005"+
		"B\u0000\u0000TU\u0005E\u0000\u0000UV\u0005R\u0000\u0000VW\u0005 \u0000"+
		"\u0000WX\u0005Q\u0000\u0000XY\u0005U\u0000\u0000YZ\u0005E\u0000\u0000"+
		"Z[\u0005S\u0000\u0000[\\\u0005T\u0000\u0000\\]\u0005I\u0000\u0000]^\u0005"+
		"O\u0000\u0000^_\u0005N\u0000\u0000_`\u0005:\u0000\u0000`\f\u0001\u0000"+
		"\u0000\u0000ab\u0005M\u0000\u0000bc\u0005U\u0000\u0000cd\u0005L\u0000"+
		"\u0000de\u0005T\u0000\u0000ef\u0005I\u0000\u0000fg\u0005P\u0000\u0000"+
		"gh\u0005L\u0000\u0000hi\u0005E\u0000\u0000ij\u0005 \u0000\u0000jk\u0005"+
		"M\u0000\u0000kl\u0005U\u0000\u0000lm\u0005L\u0000\u0000mn\u0005T\u0000"+
		"\u0000no\u0005I\u0000\u0000op\u0005P\u0000\u0000pq\u0005L\u0000\u0000"+
		"qr\u0005E\u0000\u0000rs\u0005-\u0000\u0000st\u0005C\u0000\u0000tu\u0005"+
		"H\u0000\u0000uv\u0005O\u0000\u0000vw\u0005I\u0000\u0000wx\u0005C\u0000"+
		"\u0000xy\u0005E\u0000\u0000yz\u0005 \u0000\u0000z{\u0005Q\u0000\u0000"+
		"{|\u0005U\u0000\u0000|}\u0005E\u0000\u0000}~\u0005S\u0000\u0000~\u007f"+
		"\u0005T\u0000\u0000\u007f\u0080\u0005I\u0000\u0000\u0080\u0081\u0005O"+
		"\u0000\u0000\u0081\u0082\u0005N\u0000\u0000\u0082\u0083\u0005:\u0000\u0000"+
		"\u0083\u000e\u0001\u0000\u0000\u0000\u0084\u0085\u0005T\u0000\u0000\u0085"+
		"\u0086\u0005E\u0000\u0000\u0086\u0087\u0005X\u0000\u0000\u0087\u0088\u0005"+
		"T\u0000\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u008a\u0005Q\u0000"+
		"\u0000\u008a\u008b\u0005U\u0000\u0000\u008b\u008c\u0005E\u0000\u0000\u008c"+
		"\u008d\u0005S\u0000\u0000\u008d\u008e\u0005T\u0000\u0000\u008e\u008f\u0005"+
		"I\u0000\u0000\u008f\u0090\u0005O\u0000\u0000\u0090\u0091\u0005N\u0000"+
		"\u0000\u0091\u0092\u0005:\u0000\u0000\u0092\u0010\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0005A\u0000\u0000\u0094\u0095\u0005N\u0000\u0000\u0095\u0096"+
		"\u0005S\u0000\u0000\u0096\u0097\u0005W\u0000\u0000\u0097\u0098\u0005E"+
		"\u0000\u0000\u0098\u0099\u0005R\u0000\u0000\u0099\u009a\u0005:\u0000\u0000"+
		"\u009a\u0012\u0001\u0000\u0000\u0000\u009b\u009d\u0007\u0000\u0000\u0000"+
		"\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u0014\u0001\u0000\u0000\u0000\u00a0\u00a2\u0007\u0001\u0000\u0000"+
		"\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u0016\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007\u0002\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\u0018\u0001\u0000\u0000\u0000\u00aa\u00ac\u0007\u0003\u0000\u0000"+
		"\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u001a\u0001\u0000\u0000\u0000\u0005\u0000\u009e\u00a3\u00a8\u00ad"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}