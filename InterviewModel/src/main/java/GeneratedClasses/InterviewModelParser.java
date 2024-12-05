package GeneratedClasses;// Generated from /Users/pedrom2004_/Desktop/sem4pi-23-24-2dh2/InterviewModel/src/main/java/InterviewModel.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewModelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTERVIEW_TITLE=1, DATE_TITLE=2, ABOUT_TITLE=3, EMAIL_TITLE=4, REQUIREMENT=5, 
		ANSWER=6, TRUE_FALSE_QUESTION=7, SHORT_ANSWER_QUESTION=8, SINGLE_CHOICE_QUESTION=9, 
		MULTIPLE_CHOICE_QUESTION=10, INTEGER_QUESTION=11, DECIMAL_QUESTION=12, 
		DATE_QUESTION=13, TIME_QUESTION=14, NUMERIC_SCALE_QUESTION=15, HIFEN=16, 
		DIGITO=17, INTEIRO=18, DATE=19, DIA=20, MES=21, ANO=22, DECIMAL=23, TIME=24, 
		CHOICE_ANSWER=25, NEWLINE=26, DESCRIPTION_TEXT=27;
	public static final int
		RULE_start = 0, RULE_template = 1, RULE_header = 2, RULE_interview_title_line = 3, 
		RULE_date_line = 4, RULE_description_line = 5, RULE_email_line = 6, RULE_requirements = 7, 
		RULE_requirement = 8, RULE_true_false_question = 9, RULE_short_answer_question = 10, 
		RULE_single_choice_question = 11, RULE_multiple_choice_question = 12, 
		RULE_integer_question = 13, RULE_decimal_question = 14, RULE_date_question = 15, 
		RULE_time_question = 16, RULE_numeric_scale_question = 17, RULE_option = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "template", "header", "interview_title_line", "date_line", "description_line", 
			"email_line", "requirements", "requirement", "true_false_question", "short_answer_question", 
			"single_choice_question", "multiple_choice_question", "integer_question", 
			"decimal_question", "date_question", "time_question", "numeric_scale_question", 
			"option"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'INTERVIEW: '", "'DATE: '", "'ABOUT: '", "'EMAIL: '", "'REQUIREMENT '", 
			"'ANSWER: '", "'T_F_QUESTION:'", "'SHORT_ANSWER_QUESTION:'", "'SINGLE_CHOICE_QUESTION:'", 
			"'MULTIPLE_CHOICE_QUESTION:'", "'INTEGER_QUESTION:'", "'DECIMAL_QUESTION:'", 
			"'DATE_QUESTION:'", "'TIME_QUESTION:'", "'NUMERIC_SCALE_QUESTION:'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INTERVIEW_TITLE", "DATE_TITLE", "ABOUT_TITLE", "EMAIL_TITLE", 
			"REQUIREMENT", "ANSWER", "TRUE_FALSE_QUESTION", "SHORT_ANSWER_QUESTION", 
			"SINGLE_CHOICE_QUESTION", "MULTIPLE_CHOICE_QUESTION", "INTEGER_QUESTION", 
			"DECIMAL_QUESTION", "DATE_QUESTION", "TIME_QUESTION", "NUMERIC_SCALE_QUESTION", 
			"HIFEN", "DIGITO", "INTEIRO", "DATE", "DIA", "MES", "ANO", "DECIMAL", 
			"TIME", "CHOICE_ANSWER", "NEWLINE", "DESCRIPTION_TEXT"
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
	public String getGrammarFileName() { return "InterviewModel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewModelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			template();
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
	public static class TemplateContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<RequirementsContext> requirements() {
			return getRuleContexts(RequirementsContext.class);
		}
		public RequirementsContext requirements(int i) {
			return getRuleContext(RequirementsContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			header();
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				requirements();
				}
				}
				setState(44); 
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
		public Interview_title_lineContext interview_title_line() {
			return getRuleContext(Interview_title_lineContext.class,0);
		}
		public Date_lineContext date_line() {
			return getRuleContext(Date_lineContext.class,0);
		}
		public Description_lineContext description_line() {
			return getRuleContext(Description_lineContext.class,0);
		}
		public Email_lineContext email_line() {
			return getRuleContext(Email_lineContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			interview_title_line();
			setState(47);
			date_line();
			setState(48);
			description_line();
			setState(49);
			email_line();
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
	public static class Interview_title_lineContext extends ParserRuleContext {
		public TerminalNode INTERVIEW_TITLE() { return getToken(InterviewModelParser.INTERVIEW_TITLE, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public Interview_title_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interview_title_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterInterview_title_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitInterview_title_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitInterview_title_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Interview_title_lineContext interview_title_line() throws RecognitionException {
		Interview_title_lineContext _localctx = new Interview_title_lineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interview_title_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(INTERVIEW_TITLE);
			setState(52);
			match(DESCRIPTION_TEXT);
			setState(53);
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
	public static class Date_lineContext extends ParserRuleContext {
		public TerminalNode DATE_TITLE() { return getToken(InterviewModelParser.DATE_TITLE, 0); }
		public TerminalNode DATE() { return getToken(InterviewModelParser.DATE, 0); }
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public Date_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterDate_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitDate_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitDate_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_lineContext date_line() throws RecognitionException {
		Date_lineContext _localctx = new Date_lineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_date_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(DATE_TITLE);
			setState(56);
			match(DATE);
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
	public static class Description_lineContext extends ParserRuleContext {
		public TerminalNode ABOUT_TITLE() { return getToken(InterviewModelParser.ABOUT_TITLE, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public Description_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterDescription_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitDescription_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitDescription_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Description_lineContext description_line() throws RecognitionException {
		Description_lineContext _localctx = new Description_lineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_description_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ABOUT_TITLE);
			setState(60);
			match(DESCRIPTION_TEXT);
			setState(61);
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
	public static class Email_lineContext extends ParserRuleContext {
		public TerminalNode EMAIL_TITLE() { return getToken(InterviewModelParser.EMAIL_TITLE, 0); }
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public List<TerminalNode> DESCRIPTION_TEXT() { return getTokens(InterviewModelParser.DESCRIPTION_TEXT); }
		public TerminalNode DESCRIPTION_TEXT(int i) {
			return getToken(InterviewModelParser.DESCRIPTION_TEXT, i);
		}
		public List<TerminalNode> DIGITO() { return getTokens(InterviewModelParser.DIGITO); }
		public TerminalNode DIGITO(int i) {
			return getToken(InterviewModelParser.DIGITO, i);
		}
		public Email_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterEmail_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitEmail_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitEmail_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Email_lineContext email_line() throws RecognitionException {
		Email_lineContext _localctx = new Email_lineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_email_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(EMAIL_TITLE);
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				_la = _input.LA(1);
				if ( !(_la==DIGITO || _la==DESCRIPTION_TEXT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGITO || _la==DESCRIPTION_TEXT );
			setState(69);
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
		public TerminalNode REQUIREMENT() { return getToken(InterviewModelParser.REQUIREMENT, 0); }
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public List<TerminalNode> DIGITO() { return getTokens(InterviewModelParser.DIGITO); }
		public TerminalNode DIGITO(int i) {
			return getToken(InterviewModelParser.DIGITO, i);
		}
		public List<RequirementContext> requirement() {
			return getRuleContexts(RequirementContext.class);
		}
		public RequirementContext requirement(int i) {
			return getRuleContext(RequirementContext.class,i);
		}
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterRequirements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitRequirements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitRequirements(this);
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
			setState(71);
			match(REQUIREMENT);
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				match(DIGITO);
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGITO );
			setState(77);
			match(NEWLINE);
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				requirement();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 65408L) != 0) );
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
	public static class RequirementContext extends ParserRuleContext {
		public List<True_false_questionContext> true_false_question() {
			return getRuleContexts(True_false_questionContext.class);
		}
		public True_false_questionContext true_false_question(int i) {
			return getRuleContext(True_false_questionContext.class,i);
		}
		public List<Short_answer_questionContext> short_answer_question() {
			return getRuleContexts(Short_answer_questionContext.class);
		}
		public Short_answer_questionContext short_answer_question(int i) {
			return getRuleContext(Short_answer_questionContext.class,i);
		}
		public List<Single_choice_questionContext> single_choice_question() {
			return getRuleContexts(Single_choice_questionContext.class);
		}
		public Single_choice_questionContext single_choice_question(int i) {
			return getRuleContext(Single_choice_questionContext.class,i);
		}
		public List<Multiple_choice_questionContext> multiple_choice_question() {
			return getRuleContexts(Multiple_choice_questionContext.class);
		}
		public Multiple_choice_questionContext multiple_choice_question(int i) {
			return getRuleContext(Multiple_choice_questionContext.class,i);
		}
		public List<Integer_questionContext> integer_question() {
			return getRuleContexts(Integer_questionContext.class);
		}
		public Integer_questionContext integer_question(int i) {
			return getRuleContext(Integer_questionContext.class,i);
		}
		public List<Decimal_questionContext> decimal_question() {
			return getRuleContexts(Decimal_questionContext.class);
		}
		public Decimal_questionContext decimal_question(int i) {
			return getRuleContext(Decimal_questionContext.class,i);
		}
		public List<Date_questionContext> date_question() {
			return getRuleContexts(Date_questionContext.class);
		}
		public Date_questionContext date_question(int i) {
			return getRuleContext(Date_questionContext.class,i);
		}
		public List<Time_questionContext> time_question() {
			return getRuleContexts(Time_questionContext.class);
		}
		public Time_questionContext time_question(int i) {
			return getRuleContext(Time_questionContext.class,i);
		}
		public List<Numeric_scale_questionContext> numeric_scale_question() {
			return getRuleContexts(Numeric_scale_questionContext.class);
		}
		public Numeric_scale_questionContext numeric_scale_question(int i) {
			return getRuleContext(Numeric_scale_questionContext.class,i);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_requirement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(92);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TRUE_FALSE_QUESTION:
						{
						setState(83);
						true_false_question();
						}
						break;
					case SHORT_ANSWER_QUESTION:
						{
						setState(84);
						short_answer_question();
						}
						break;
					case SINGLE_CHOICE_QUESTION:
						{
						setState(85);
						single_choice_question();
						}
						break;
					case MULTIPLE_CHOICE_QUESTION:
						{
						setState(86);
						multiple_choice_question();
						}
						break;
					case INTEGER_QUESTION:
						{
						setState(87);
						integer_question();
						}
						break;
					case DECIMAL_QUESTION:
						{
						setState(88);
						decimal_question();
						}
						break;
					case DATE_QUESTION:
						{
						setState(89);
						date_question();
						}
						break;
					case TIME_QUESTION:
						{
						setState(90);
						time_question();
						}
						break;
					case NUMERIC_SCALE_QUESTION:
						{
						setState(91);
						numeric_scale_question();
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
				setState(94); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class True_false_questionContext extends ParserRuleContext {
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewModelParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode CHOICE_ANSWER() { return getToken(InterviewModelParser.CHOICE_ANSWER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public True_false_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitTrue_false_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitTrue_false_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_true_false_question);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(TRUE_FALSE_QUESTION);
			setState(97);
			match(DESCRIPTION_TEXT);
			setState(99); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(98);
					option();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(101); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(103);
			match(NEWLINE);
			setState(104);
			match(ANSWER);
			setState(105);
			match(CHOICE_ANSWER);
			setState(106);
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
	public static class Short_answer_questionContext extends ParserRuleContext {
		public TerminalNode SHORT_ANSWER_QUESTION() { return getToken(InterviewModelParser.SHORT_ANSWER_QUESTION, 0); }
		public List<TerminalNode> DESCRIPTION_TEXT() { return getTokens(InterviewModelParser.DESCRIPTION_TEXT); }
		public TerminalNode DESCRIPTION_TEXT(int i) {
			return getToken(InterviewModelParser.DESCRIPTION_TEXT, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public Short_answer_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterShort_answer_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitShort_answer_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitShort_answer_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questionContext short_answer_question() throws RecognitionException {
		Short_answer_questionContext _localctx = new Short_answer_questionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_short_answer_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(SHORT_ANSWER_QUESTION);
			setState(109);
			match(DESCRIPTION_TEXT);
			setState(110);
			match(NEWLINE);
			setState(111);
			match(ANSWER);
			setState(112);
			match(DESCRIPTION_TEXT);
			setState(113);
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
	public static class Single_choice_questionContext extends ParserRuleContext {
		public TerminalNode SINGLE_CHOICE_QUESTION() { return getToken(InterviewModelParser.SINGLE_CHOICE_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode CHOICE_ANSWER() { return getToken(InterviewModelParser.CHOICE_ANSWER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public Single_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterSingle_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitSingle_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitSingle_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choice_questionContext single_choice_question() throws RecognitionException {
		Single_choice_questionContext _localctx = new Single_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_single_choice_question);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(SINGLE_CHOICE_QUESTION);
			setState(116);
			match(DESCRIPTION_TEXT);
			setState(118); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(117);
					option();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(120); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(122);
			match(NEWLINE);
			setState(123);
			match(ANSWER);
			setState(124);
			match(CHOICE_ANSWER);
			setState(125);
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
	public static class Multiple_choice_questionContext extends ParserRuleContext {
		public TerminalNode MULTIPLE_CHOICE_QUESTION() { return getToken(InterviewModelParser.MULTIPLE_CHOICE_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode CHOICE_ANSWER() { return getToken(InterviewModelParser.CHOICE_ANSWER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public Multiple_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitMultiple_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitMultiple_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiple_choice_question);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(MULTIPLE_CHOICE_QUESTION);
			setState(128);
			match(DESCRIPTION_TEXT);
			setState(130); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(129);
					option();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(132); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(134);
			match(NEWLINE);
			setState(135);
			match(ANSWER);
			setState(136);
			match(CHOICE_ANSWER);
			setState(137);
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
	public static class Integer_questionContext extends ParserRuleContext {
		public TerminalNode INTEGER_QUESTION() { return getToken(InterviewModelParser.INTEGER_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode INTEIRO() { return getToken(InterviewModelParser.INTEIRO, 0); }
		public TerminalNode DIGITO() { return getToken(InterviewModelParser.DIGITO, 0); }
		public Integer_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterInteger_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitInteger_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitInteger_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_questionContext integer_question() throws RecognitionException {
		Integer_questionContext _localctx = new Integer_questionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_integer_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(INTEGER_QUESTION);
			setState(140);
			match(DESCRIPTION_TEXT);
			setState(141);
			match(NEWLINE);
			setState(142);
			match(ANSWER);
			setState(143);
			_la = _input.LA(1);
			if ( !(_la==DIGITO || _la==INTEIRO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(144);
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
	public static class Decimal_questionContext extends ParserRuleContext {
		public TerminalNode DECIMAL_QUESTION() { return getToken(InterviewModelParser.DECIMAL_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode DECIMAL() { return getToken(InterviewModelParser.DECIMAL, 0); }
		public Decimal_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterDecimal_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitDecimal_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitDecimal_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_questionContext decimal_question() throws RecognitionException {
		Decimal_questionContext _localctx = new Decimal_questionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_decimal_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(DECIMAL_QUESTION);
			setState(147);
			match(DESCRIPTION_TEXT);
			setState(148);
			match(NEWLINE);
			setState(149);
			match(ANSWER);
			setState(150);
			match(DECIMAL);
			setState(151);
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
	public static class Date_questionContext extends ParserRuleContext {
		public TerminalNode DATE_QUESTION() { return getToken(InterviewModelParser.DATE_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode DATE() { return getToken(InterviewModelParser.DATE, 0); }
		public Date_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterDate_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitDate_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitDate_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_questionContext date_question() throws RecognitionException {
		Date_questionContext _localctx = new Date_questionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_date_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(DATE_QUESTION);
			setState(154);
			match(DESCRIPTION_TEXT);
			setState(155);
			match(NEWLINE);
			setState(156);
			match(ANSWER);
			setState(157);
			match(DATE);
			setState(158);
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
	public static class Time_questionContext extends ParserRuleContext {
		public TerminalNode TIME_QUESTION() { return getToken(InterviewModelParser.TIME_QUESTION, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public TerminalNode TIME() { return getToken(InterviewModelParser.TIME, 0); }
		public Time_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterTime_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitTime_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitTime_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_questionContext time_question() throws RecognitionException {
		Time_questionContext _localctx = new Time_questionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_time_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(TIME_QUESTION);
			setState(161);
			match(DESCRIPTION_TEXT);
			setState(162);
			match(NEWLINE);
			setState(163);
			match(ANSWER);
			setState(164);
			match(TIME);
			setState(165);
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
	public static class Numeric_scale_questionContext extends ParserRuleContext {
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewModelParser.NUMERIC_SCALE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewModelParser.NEWLINE, i);
		}
		public TerminalNode ANSWER() { return getToken(InterviewModelParser.ANSWER, 0); }
		public List<TerminalNode> DIGITO() { return getTokens(InterviewModelParser.DIGITO); }
		public TerminalNode DIGITO(int i) {
			return getToken(InterviewModelParser.DIGITO, i);
		}
		public List<TerminalNode> DESCRIPTION_TEXT() { return getTokens(InterviewModelParser.DESCRIPTION_TEXT); }
		public TerminalNode DESCRIPTION_TEXT(int i) {
			return getToken(InterviewModelParser.DESCRIPTION_TEXT, i);
		}
		public List<TerminalNode> INTEIRO() { return getTokens(InterviewModelParser.INTEIRO); }
		public TerminalNode INTEIRO(int i) {
			return getToken(InterviewModelParser.INTEIRO, i);
		}
		public Numeric_scale_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_scale_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterNumeric_scale_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitNumeric_scale_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitNumeric_scale_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_scale_questionContext numeric_scale_question() throws RecognitionException {
		Numeric_scale_questionContext _localctx = new Numeric_scale_questionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numeric_scale_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(NUMERIC_SCALE_QUESTION);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 134610944L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 134610944L) != 0) );
			setState(173);
			match(NEWLINE);
			setState(174);
			match(ANSWER);
			setState(175);
			match(DIGITO);
			setState(176);
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
	public static class OptionContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(InterviewModelParser.NEWLINE, 0); }
		public TerminalNode DESCRIPTION_TEXT() { return getToken(InterviewModelParser.DESCRIPTION_TEXT, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewModelListener ) ((InterviewModelListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewModelVisitor ) return ((InterviewModelVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(NEWLINE);
			setState(179);
			match(DESCRIPTION_TEXT);
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
		"\u0004\u0001\u001b\u00b6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001+\b"+
		"\u0001\u000b\u0001\f\u0001,\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0004\u0006B\b\u0006\u000b"+
		"\u0006\f\u0006C\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0004"+
		"\u0007J\b\u0007\u000b\u0007\f\u0007K\u0001\u0007\u0001\u0007\u0004\u0007"+
		"P\b\u0007\u000b\u0007\f\u0007Q\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b]\b\b\u000b\b\f\b^\u0001\t\u0001"+
		"\t\u0001\t\u0004\td\b\t\u000b\t\f\te\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0004\u000bw\b\u000b\u000b\u000b\f\u000bx\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0004\f\u0083\b\f\u000b\f\f\f\u0084\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0004\u0011\u00aa"+
		"\b\u0011\u000b\u0011\f\u0011\u00ab\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0003\u0002\u0000\u0011\u0011"+
		"\u001b\u001b\u0001\u0000\u0011\u0012\u0002\u0000\u0011\u0012\u001b\u001b"+
		"\u00b3\u0000&\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004"+
		".\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000\b7\u0001\u0000"+
		"\u0000\u0000\n;\u0001\u0000\u0000\u0000\f?\u0001\u0000\u0000\u0000\u000e"+
		"G\u0001\u0000\u0000\u0000\u0010\\\u0001\u0000\u0000\u0000\u0012`\u0001"+
		"\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016s\u0001\u0000\u0000"+
		"\u0000\u0018\u007f\u0001\u0000\u0000\u0000\u001a\u008b\u0001\u0000\u0000"+
		"\u0000\u001c\u0092\u0001\u0000\u0000\u0000\u001e\u0099\u0001\u0000\u0000"+
		"\u0000 \u00a0\u0001\u0000\u0000\u0000\"\u00a7\u0001\u0000\u0000\u0000"+
		"$\u00b2\u0001\u0000\u0000\u0000&\'\u0003\u0002\u0001\u0000\'\u0001\u0001"+
		"\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)+\u0003\u000e\u0007\u0000"+
		"*)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-\u0003\u0001\u0000\u0000\u0000./\u0003"+
		"\u0006\u0003\u0000/0\u0003\b\u0004\u000001\u0003\n\u0005\u000012\u0003"+
		"\f\u0006\u00002\u0005\u0001\u0000\u0000\u000034\u0005\u0001\u0000\u0000"+
		"45\u0005\u001b\u0000\u000056\u0005\u001a\u0000\u00006\u0007\u0001\u0000"+
		"\u0000\u000078\u0005\u0002\u0000\u000089\u0005\u0013\u0000\u00009:\u0005"+
		"\u001a\u0000\u0000:\t\u0001\u0000\u0000\u0000;<\u0005\u0003\u0000\u0000"+
		"<=\u0005\u001b\u0000\u0000=>\u0005\u001a\u0000\u0000>\u000b\u0001\u0000"+
		"\u0000\u0000?A\u0005\u0004\u0000\u0000@B\u0007\u0000\u0000\u0000A@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0005\u001a\u0000"+
		"\u0000F\r\u0001\u0000\u0000\u0000GI\u0005\u0005\u0000\u0000HJ\u0005\u0011"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MO\u0005\u001a\u0000\u0000NP\u0003\u0010\b\u0000ON\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000R\u000f\u0001\u0000\u0000\u0000S]\u0003\u0012\t\u0000T]\u0003\u0014"+
		"\n\u0000U]\u0003\u0016\u000b\u0000V]\u0003\u0018\f\u0000W]\u0003\u001a"+
		"\r\u0000X]\u0003\u001c\u000e\u0000Y]\u0003\u001e\u000f\u0000Z]\u0003 "+
		"\u0010\u0000[]\u0003\"\u0011\u0000\\S\u0001\u0000\u0000\u0000\\T\u0001"+
		"\u0000\u0000\u0000\\U\u0001\u0000\u0000\u0000\\V\u0001\u0000\u0000\u0000"+
		"\\W\u0001\u0000\u0000\u0000\\X\u0001\u0000\u0000\u0000\\Y\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_\u0011\u0001\u0000\u0000\u0000`a\u0005\u0007\u0000\u0000ac\u0005\u001b"+
		"\u0000\u0000bd\u0003$\u0012\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000gh\u0005\u001a\u0000\u0000hi\u0005\u0006\u0000\u0000"+
		"ij\u0005\u0019\u0000\u0000jk\u0005\u001a\u0000\u0000k\u0013\u0001\u0000"+
		"\u0000\u0000lm\u0005\b\u0000\u0000mn\u0005\u001b\u0000\u0000no\u0005\u001a"+
		"\u0000\u0000op\u0005\u0006\u0000\u0000pq\u0005\u001b\u0000\u0000qr\u0005"+
		"\u001a\u0000\u0000r\u0015\u0001\u0000\u0000\u0000st\u0005\t\u0000\u0000"+
		"tv\u0005\u001b\u0000\u0000uw\u0003$\u0012\u0000vu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u001a\u0000\u0000{|\u0005\u0006"+
		"\u0000\u0000|}\u0005\u0019\u0000\u0000}~\u0005\u001a\u0000\u0000~\u0017"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0005\n\u0000\u0000\u0080\u0082\u0005"+
		"\u001b\u0000\u0000\u0081\u0083\u0003$\u0012\u0000\u0082\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u001a\u0000\u0000\u0087\u0088\u0005\u0006"+
		"\u0000\u0000\u0088\u0089\u0005\u0019\u0000\u0000\u0089\u008a\u0005\u001a"+
		"\u0000\u0000\u008a\u0019\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000b"+
		"\u0000\u0000\u008c\u008d\u0005\u001b\u0000\u0000\u008d\u008e\u0005\u001a"+
		"\u0000\u0000\u008e\u008f\u0005\u0006\u0000\u0000\u008f\u0090\u0007\u0001"+
		"\u0000\u0000\u0090\u0091\u0005\u001a\u0000\u0000\u0091\u001b\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\f\u0000\u0000\u0093\u0094\u0005\u001b\u0000"+
		"\u0000\u0094\u0095\u0005\u001a\u0000\u0000\u0095\u0096\u0005\u0006\u0000"+
		"\u0000\u0096\u0097\u0005\u0017\u0000\u0000\u0097\u0098\u0005\u001a\u0000"+
		"\u0000\u0098\u001d\u0001\u0000\u0000\u0000\u0099\u009a\u0005\r\u0000\u0000"+
		"\u009a\u009b\u0005\u001b\u0000\u0000\u009b\u009c\u0005\u001a\u0000\u0000"+
		"\u009c\u009d\u0005\u0006\u0000\u0000\u009d\u009e\u0005\u0013\u0000\u0000"+
		"\u009e\u009f\u0005\u001a\u0000\u0000\u009f\u001f\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005\u000e\u0000\u0000\u00a1\u00a2\u0005\u001b\u0000\u0000"+
		"\u00a2\u00a3\u0005\u001a\u0000\u0000\u00a3\u00a4\u0005\u0006\u0000\u0000"+
		"\u00a4\u00a5\u0005\u0018\u0000\u0000\u00a5\u00a6\u0005\u001a\u0000\u0000"+
		"\u00a6!\u0001\u0000\u0000\u0000\u00a7\u00a9\u0005\u000f\u0000\u0000\u00a8"+
		"\u00aa\u0007\u0002\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0005\u001a\u0000\u0000\u00ae\u00af\u0005\u0006\u0000\u0000\u00af"+
		"\u00b0\u0005\u0011\u0000\u0000\u00b0\u00b1\u0005\u001a\u0000\u0000\u00b1"+
		"#\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3\u00b4"+
		"\u0005\u001b\u0000\u0000\u00b4%\u0001\u0000\u0000\u0000\n,CKQ\\^ex\u0084"+
		"\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}