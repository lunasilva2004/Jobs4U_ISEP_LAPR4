package GeneratedClasses;// Generated from /Users/josemendes/Documents/IdeaProjects/sem4pi-23-24-2dh2/JobRequirementsSpecification/src/main/java/JobRequirementsSpecification.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JobRequirementsSpecificationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TITLE=1, COMPANY=2, JOB=3, EMAIL=4, REQUIREMENT=5, NUMBERQ=6, MULTIPLEQ=7, 
		TEXTQ=8, ANSEWER=9, NUMBER=10, MULTIPLANSEWER=11, NEWLINE=12, DESCRIPTION=13;
	public static final int
		RULE_start = 0, RULE_specification = 1, RULE_header = 2, RULE_title = 3, 
		RULE_company_name = 4, RULE_description = 5, RULE_email = 6, RULE_requirements = 7, 
		RULE_question = 8, RULE_number = 9, RULE_multiple = 10, RULE_text = 11, 
		RULE_options = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "specification", "header", "title", "company_name", "description", 
			"email", "requirements", "question", "number", "multiple", "text", "options"
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

	@Override
	public String getGrammarFileName() { return "JobRequirementsSpecification.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JobRequirementsSpecificationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public SpecificationContext specification() {
			return getRuleContext(SpecificationContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecificationContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<RequirementsContext> requirements() {
			return getRuleContexts(RequirementsContext.class);
		}
		public RequirementsContext requirements(int i) {
			return getRuleContext(RequirementsContext.class,i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			header();
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				requirements();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==REQUIREMENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public Company_nameContext company_name() {
			return getRuleContext(Company_nameContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			title();
			setState(35);
			company_name();
			setState(36);
			description();
			setState(37);
			email();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TITLE() { return getToken(JobRequirementsSpecificationParser.TITLE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(TITLE);
			setState(40);
			match(DESCRIPTION);
			setState(41);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Company_nameContext extends ParserRuleContext {
		public TerminalNode COMPANY() { return getToken(JobRequirementsSpecificationParser.COMPANY, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public Company_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_company_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterCompany_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitCompany_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitCompany_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Company_nameContext company_name() throws RecognitionException {
		Company_nameContext _localctx = new Company_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_company_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(COMPANY);
			setState(44);
			match(DESCRIPTION);
			setState(45);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode JOB() { return getToken(JobRequirementsSpecificationParser.JOB, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(JOB);
			setState(48);
			match(DESCRIPTION);
			setState(49);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmailContext extends ParserRuleContext {
		public TerminalNode EMAIL() { return getToken(JobRequirementsSpecificationParser.EMAIL, 0); }
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public List<TerminalNode> DESCRIPTION() { return getTokens(JobRequirementsSpecificationParser.DESCRIPTION); }
		public TerminalNode DESCRIPTION(int i) {
			return getToken(JobRequirementsSpecificationParser.DESCRIPTION, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(JobRequirementsSpecificationParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(JobRequirementsSpecificationParser.NUMBER, i);
		}
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_email);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(EMAIL);
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==DESCRIPTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==DESCRIPTION );
			setState(57);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequirementsContext extends ParserRuleContext {
		public TerminalNode REQUIREMENT() { return getToken(JobRequirementsSpecificationParser.REQUIREMENT, 0); }
		public TerminalNode NUMBER() { return getToken(JobRequirementsSpecificationParser.NUMBER, 0); }
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterRequirements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitRequirements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitRequirements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementsContext requirements() throws RecognitionException {
		RequirementsContext _localctx = new RequirementsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_requirements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(REQUIREMENT);
			setState(60);
			match(NUMBER);
			setState(61);
			match(NEWLINE);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				question();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<MultipleContext> multiple() {
			return getRuleContexts(MultipleContext.class);
		}
		public MultipleContext multiple(int i) {
			return getRuleContext(MultipleContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(70);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NUMBERQ:
						{
						setState(67);
						number();
						}
						break;
					case MULTIPLEQ:
						{
						setState(68);
						multiple();
						}
						break;
					case TEXTQ:
						{
						setState(69);
						text();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(72); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBERQ() { return getToken(JobRequirementsSpecificationParser.NUMBERQ, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsSpecificationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsSpecificationParser.NEWLINE, i);
		}
		public TerminalNode ANSEWER() { return getToken(JobRequirementsSpecificationParser.ANSEWER, 0); }
		public TerminalNode NUMBER() { return getToken(JobRequirementsSpecificationParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(NUMBERQ);
			setState(75);
			match(DESCRIPTION);
			setState(76);
			match(NEWLINE);
			setState(77);
			match(ANSEWER);
			setState(78);
			match(NUMBER);
			setState(79);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultipleContext extends ParserRuleContext {
		public TerminalNode MULTIPLEQ() { return getToken(JobRequirementsSpecificationParser.MULTIPLEQ, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsSpecificationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsSpecificationParser.NEWLINE, i);
		}
		public TerminalNode ANSEWER() { return getToken(JobRequirementsSpecificationParser.ANSEWER, 0); }
		public TerminalNode MULTIPLANSEWER() { return getToken(JobRequirementsSpecificationParser.MULTIPLANSEWER, 0); }
		public List<OptionsContext> options() {
			return getRuleContexts(OptionsContext.class);
		}
		public OptionsContext options(int i) {
			return getRuleContext(OptionsContext.class,i);
		}
		public MultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleContext multiple() throws RecognitionException {
		MultipleContext _localctx = new MultipleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(MULTIPLEQ);
			setState(82);
			match(DESCRIPTION);
			setState(84); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(83);
					options();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(86); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(88);
			match(NEWLINE);
			setState(89);
			match(ANSEWER);
			setState(90);
			match(MULTIPLANSEWER);
			setState(91);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXTQ() { return getToken(JobRequirementsSpecificationParser.TEXTQ, 0); }
		public List<TerminalNode> DESCRIPTION() { return getTokens(JobRequirementsSpecificationParser.DESCRIPTION); }
		public TerminalNode DESCRIPTION(int i) {
			return getToken(JobRequirementsSpecificationParser.DESCRIPTION, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsSpecificationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsSpecificationParser.NEWLINE, i);
		}
		public TerminalNode ANSEWER() { return getToken(JobRequirementsSpecificationParser.ANSEWER, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(TEXTQ);
			setState(94);
			match(DESCRIPTION);
			setState(95);
			match(NEWLINE);
			setState(96);
			match(ANSEWER);
			setState(97);
			match(DESCRIPTION);
			setState(98);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionsContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(JobRequirementsSpecificationParser.NEWLINE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(JobRequirementsSpecificationParser.DESCRIPTION, 0); }
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsSpecificationListener ) ((JobRequirementsSpecificationListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsSpecificationVisitor ) return ((JobRequirementsSpecificationVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(NEWLINE);
			setState(101);
			match(DESCRIPTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\rh\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001"+
		"\u001f\b\u0001\u000b\u0001\f\u0001 \u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0004\u00066\b\u0006"+
		"\u000b\u0006\f\u00067\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007@\b\u0007\u000b\u0007\f\u0007A\u0001"+
		"\b\u0001\b\u0001\b\u0004\bG\b\b\u000b\b\f\bH\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0004\nU\b\n\u000b"+
		"\n\f\nV\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0001\u0002\u0000\n\n\r\ra\u0000\u001a"+
		"\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004\"\u0001"+
		"\u0000\u0000\u0000\u0006\'\u0001\u0000\u0000\u0000\b+\u0001\u0000\u0000"+
		"\u0000\n/\u0001\u0000\u0000\u0000\f3\u0001\u0000\u0000\u0000\u000e;\u0001"+
		"\u0000\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012J\u0001\u0000\u0000"+
		"\u0000\u0014Q\u0001\u0000\u0000\u0000\u0016]\u0001\u0000\u0000\u0000\u0018"+
		"d\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u0001"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0004\u0002\u0000\u001d\u001f"+
		"\u0003\u000e\u0007\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000"+
		"\u0000!\u0003\u0001\u0000\u0000\u0000\"#\u0003\u0006\u0003\u0000#$\u0003"+
		"\b\u0004\u0000$%\u0003\n\u0005\u0000%&\u0003\f\u0006\u0000&\u0005\u0001"+
		"\u0000\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0005\r\u0000\u0000)*"+
		"\u0005\f\u0000\u0000*\u0007\u0001\u0000\u0000\u0000+,\u0005\u0002\u0000"+
		"\u0000,-\u0005\r\u0000\u0000-.\u0005\f\u0000\u0000.\t\u0001\u0000\u0000"+
		"\u0000/0\u0005\u0003\u0000\u000001\u0005\r\u0000\u000012\u0005\f\u0000"+
		"\u00002\u000b\u0001\u0000\u0000\u000035\u0005\u0004\u0000\u000046\u0007"+
		"\u0000\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009:\u0005\f\u0000\u0000:\r\u0001\u0000\u0000\u0000;<\u0005\u0005"+
		"\u0000\u0000<=\u0005\n\u0000\u0000=?\u0005\f\u0000\u0000>@\u0003\u0010"+
		"\b\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000B\u000f\u0001\u0000\u0000\u0000"+
		"CG\u0003\u0012\t\u0000DG\u0003\u0014\n\u0000EG\u0003\u0016\u000b\u0000"+
		"FC\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000I\u0011\u0001\u0000\u0000\u0000JK\u0005\u0006\u0000\u0000"+
		"KL\u0005\r\u0000\u0000LM\u0005\f\u0000\u0000MN\u0005\t\u0000\u0000NO\u0005"+
		"\n\u0000\u0000OP\u0005\f\u0000\u0000P\u0013\u0001\u0000\u0000\u0000QR"+
		"\u0005\u0007\u0000\u0000RT\u0005\r\u0000\u0000SU\u0003\u0018\f\u0000T"+
		"S\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005\f\u0000"+
		"\u0000YZ\u0005\t\u0000\u0000Z[\u0005\u000b\u0000\u0000[\\\u0005\f\u0000"+
		"\u0000\\\u0015\u0001\u0000\u0000\u0000]^\u0005\b\u0000\u0000^_\u0005\r"+
		"\u0000\u0000_`\u0005\f\u0000\u0000`a\u0005\t\u0000\u0000ab\u0005\r\u0000"+
		"\u0000bc\u0005\f\u0000\u0000c\u0017\u0001\u0000\u0000\u0000de\u0005\f"+
		"\u0000\u0000ef\u0005\r\u0000\u0000f\u0019\u0001\u0000\u0000\u0000\u0006"+
		" 7AFHV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}