import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:alan_voice/alan_voice.dart';
import 'package:flutter/services.dart';
import 'models/article.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'News App'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  final String title;
  MyHomePage({Key key, this.title}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Article> articles;
  bool isNewsAvailable = false;
  _MyHomePageState() {
    AlanVoice.addButton(
        "cd7f7d0846ddf1d71cd3f86d54b7142e2e956eca572e1d8b807a3e2338fdd0dc/stage");
    AlanVoice.callbacks.add((command) => _handleCommand(command.data));
  }

  @override
  void initState() {
    SystemChrome.setPreferredOrientations([
      DeviceOrientation.portraitUp,
      DeviceOrientation.portraitDown,
    ]);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: isNewsAvailable
          ? ListView.builder(
              itemCount: articles.length,
              itemBuilder: (BuildContext context, index) {
                final Article article = articles[index];
                return NewsCard(image: article.image, title: article.title);
              })
          : Center(
              child: Text(
                'Try Saying: Give me some latest news....',
                style: const TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 15,
                  fontStyle: FontStyle.italic,
                  color: Colors.blueAccent,
                ),
              ),
            ),
    );
  }

  @override
  void dispose() {
    SystemChrome.setPreferredOrientations([
      DeviceOrientation.landscapeRight,
      DeviceOrientation.landscapeLeft,
      DeviceOrientation.portraitUp,
      DeviceOrientation.portraitDown,
    ]);
    super.dispose();
  }

  void _handleCommand(Map<String, dynamic> command) {
    // call client code that will react to the received command
    List<Article> list = List<Article>();

    command["articles"].forEach((article) {
      list.add(Article(article["urlToImage"], article["title"],
          article["description"], article["url"], article["source"]));
    });
    setState(() {
      this.articles = list;
      isNewsAvailable = true;
    });
  }
}

class NewsCard extends StatelessWidget {
  final String image;
  final String title;
  final String description;
  final String url;
  final String source;

  const NewsCard({
    Key key,
    @required this.image,
    @required this.title,
    this.description,
    this.url,
    this.source,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.fromLTRB(10, 10, 10, 10),
      height: 300,
      width: double.maxFinite,
      child: Card(
        elevation: 5,
        child: Column(
          children: [
            Container(
              child: CachedNetworkImage(
                height: 200,
                fit: BoxFit.contain,
                imageUrl: image ??
                    "https://media4.s-nbcnews.com/i/newscms/2019_01/2705191/nbc-social-default_b6fa4fef0d31ca7e8bc7ff6d117ca9f4.png",
                placeholder: (context, url) => CircularProgressIndicator(),
                errorWidget: (context, url, error) => Icon(Icons.error),
              ),
            ),
            const SizedBox(height: 5),
            Text(title),
          ],
        ),
      ),
    );
  }
}
