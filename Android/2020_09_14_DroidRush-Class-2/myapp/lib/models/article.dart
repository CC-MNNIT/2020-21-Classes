class Article {
  dynamic _image;
  dynamic _title;
  dynamic _description;
  dynamic _url;
  dynamic _source;

  Article(this._image, this._title, this._description, this._url, this._source);

  dynamic get image => _image;
  dynamic get title => _title;
  dynamic get description => _description;
  dynamic get url => _url;
  dynamic get source => _source;
}
