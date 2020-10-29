from nltk.tokenize import word_tokenize, sent_tokenize
from nltk import RegexpParser, pos_tag

content = """Bitcoin has pulled back from 2020’s highs while ether slips as DeFi cools off.

Bitcoin (BTC) trading around $12,919.97 as of 20:00 UTC (4 p.m. ET). Slipping 1.36% over the previous 24 hours.
Bitcoin’s 24-hour range: $12,731.06-$13,192.25.

Bitcoin’s price had a minor pullback Friday after hitting fresh new 2020 highs that put it above $13,000 in the past week. However, analysts and traders said they were not surprised at all by the recent moves. 

Read More: Active Bitcoin Addresses at Highest Since 2017’s $20K Price Record
Subscribe to First Mover, our daily newsletter about markets.
By signing up, you will receive emails about CoinDesk products and you agree to our terms & conditions and privacy policy.

An immediate sell-off by long-time bitcoin holders when prices hovered around $13,000 could be why bitcoin struggled to maintain its rally, according to on-chain data site Santiment.

Bitcoin’s dormant circulation, which tracks the activity of bitcoin that were previously unmoved for at least one year, has recorded the biggest spike since Feb. 7, 2020, Santiment’s data shows.
photo_2020-10-23-14-00-22
Movement of dormant bitcoin for at least 365 days.
Source: Santiment

“A renewed activity of long-term BTC investors often means increased price volatility up ahead,” Dino Ibisbegovic, market analyst at Santiment, told CoinDesk. “Similar spikes – particularly during price rallies – have typically earmarked periods of price consolidation or short-term corrections in the past.”

Darius Sit, founder of Singapore-based QCP Capital, told CoinDesk the market may expect further pullback over the weekend, noting that the TD Sequential indicator has been able to signal a reversal for bitcoin prices.

On the other hand, growing open options interest may support a pricing floor for bitcoin above $12,500, said Guy Hirsch, managing director of U.S. for eToro, in an email to CoinDesk. 

“That price point has long been seen as the glass ceiling that needed to break for BTC to make any significant moves upward,” Hirsch said. “Given the positive sentiment off the back of yesterday’s PayPal news, I would not be surprised to see bitcoin challenged and move back past $13,000 in the near future.”
skew_total_btc_options_open_interest
Total BTC options open interest since Sept. 23.
Source: Skew

Additionally, significant institutional interest in cryptocurrency has continued to grow. That is evidenced by the fact that this week the tCME, an exchange predominantly led by institutional participation, has surpassed both Binance and BitMEX to be the second-largest bitcoin futures platform by number of open contracts.

Read More: CME’s Rise in Bitcoin Futures Rankings Signals Growing Institutional Interest

“The PayPal news is the bright and shiny object this week, but it is just the tip of the iceberg,” Matt Hougan, global head of research at Bitwise Asset Management, told CoinDesk. “Behind the scenes there has been a sea change in the attitudes of institutional investors, broker-dealers and financial advisers toward crypto in the past few months.”

“We’re in a legitimate bull market right now,” he added.
Ether slips as DeFi cools off

The second-largest cryptocurrency by market capitalization, ether (ETH), was down Friday trading around $409.05 and slipping 1.78% in 24 hours as of 20:00 UTC (4:00 p.m. ET).

Priced in bitcoin, the token started to reverse some of the gains made mid-Thursday when ETH/BTC spiked 4% in two hours, down 2% from the daily high and trading at 0.0317 BTC per ether and continuing the downward trend since the week’s open for bitcoin-based trading pair.

Ether’s decline against bitcoin may signal a continued cooling of alternate cryptocurrencies (altcoins). Taking to Twitter, leading markets data provider Skew noted ether’s downward trend, asking rhetorically, “Altseason on pause?”

Decentralized finance (DeFi) led the summer’s surge in altcoin returns, and plummeting decentralized exchange (DEX) trading volumes corroborate a potentially significant waning of speculative interest in altcoins, especially DeFi-focused assets. The 30-day trailing volume for leading DEXs is down 41%, according to data from Dune Analytics.
Other markets

Digital assets on the CoinDesk 20 are all red Friday. The bigger losers as of 20:00 UTC (4:00 p.m. ET):

    Zcash (ZEC) - 6.16%
    Dash (DASH) - 5.46%
    XRP (XRP) - 4.09%

Read More: Five On-Chain Indicators Investors Should Follow: Chainalysis

Equities:

    The Nikkei 225 in Asia closed up 0.18% after the final U.S. presidential debate between Donald Trump and Joe Biden ended up much less chaotic compared with the first debate.
    The FTSE 100 also ended the day in the green 1.29% as Barclays beat market expectations by logging a strong third-quarter profit.
    In the United States the S&P 500 gained 0.34% as investors continue to focus on the econonic stimulus negotiations in Washington, D.C.

Commodities:

    Oil was down 2.13%. Price per barrel of West Texas Intermediate crude: $39.482.
    Gold was in the red 0.03% and at $1902.97 as of press time.

Treasurys:

    U.S. Treasury bond yields went down Friday. Ten-year yields, which move in the opposite direction as price, were down to 0.85.

Read more about...
EthereumCommoditiesBitcoinEquitiesMarket Wrap
Disclosure
The leader in blockchain news, CoinDesk is a media outlet that strives for the highest journalistic standards and abides by a strict set of editorial policies. CoinDesk is an independent operating subsidiary of Digital Currency Group, which invests in cryptocurrencies and blockchain startups."""

sentence = """Looking at the Moving Average Convergence Divergence (MACD), it is clear that buyers will stay in control despite the stalling at $13,800. Once the hurdle at $14,000 is broken sometime next week, the flagship cryptocurrency is likely to rush towards $15,000 by the end of November."""
temporary = """Bitcoin will hit $15000 by January."""

def interpret_content(content):
    tokens = sent_tokenize(content)

    for i in tokens:
        token = word_tokenize(i)
        pos_tagged = pos_tag(token)

        pattern = """Chunk: {<NNP>.*<MD>.*<VB>.*<CD>}"""
        chunker = RegexpParser(pattern)

        output = chunker.parse(pos_tagged)
        output.draw()

    return 0

def interpretPricePrediction(content):
  btc_inter = ["bitcoin", "bitcoins", "btc", "xbt"]
  btc_inter += [i.capitalize() for i in btc_inter] + [i.upper() for i in btc_inter]
  
  tokens = sent_tokenize(content)
  
  for i in tokens:
    token = word_tokenize(i)
    pos_tagged = pos_tag(token)
    
    pattern = """Chunk: {}"""
    chunker = RegexpParser(pattern)
    
    output = chunker.parse(pos_tagged)
    output.draw()

if __name__ == "__main__":
    output = interpretPricePrediction(temporary)