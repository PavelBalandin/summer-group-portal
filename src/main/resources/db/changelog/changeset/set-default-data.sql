----------------------------------------------------------------
-- ROLES
----------------------------------------------------------------
INSERT INTO roles VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO roles VALUES (DEFAULT, 'ROLE_MODERATOR');
INSERT INTO roles VALUES (DEFAULT, 'ROLE_CONTRIBUTOR');
INSERT INTO roles VALUES (DEFAULT, 'ROLE_ADMIN');
----------------------------------------------------------------
-- TAGS
----------------------------------------------------------------
INSERT INTO tags VALUES (DEFAULT, 'Алиса', '#ffaf30', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Лена', '#58408a', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Славя', '#feef9e', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Ульяна', '#b0282a', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Мику', '#76c7c0', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Юля', '#ebb183', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Ольга', '#37b032', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Виола', '#ffffc9', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Электроник', '#ffffc9', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Шурик', '#ffffc9', 'character', 'В моде присутствует рут посвящённый этому персонажу');
INSERT INTO tags VALUES (DEFAULT, 'Пионер', '#f22626', 'character', 'В моде присутствует рут посвящённый этому персонажу');

INSERT INTO tags VALUES (DEFAULT, 'Линейный', '#6b6b6b', 'narrative', 'В моде присутствует только один рут');
INSERT INTO tags VALUES (DEFAULT, 'Разветвленный', '#6b6b6b', 'narrative', 'В моде присутствует несколько рутов');
INSERT INTO tags VALUES (DEFAULT, 'Короткий', '#6b6b6b', 'narrative', 'Короткий по продолжительности мод');
INSERT INTO tags VALUES (DEFAULT, 'Средний', '#6b6b6b', 'narrative', 'Короткий по продолжительности мод');
INSERT INTO tags VALUES (DEFAULT, 'Длинный', '#6b6b6b', 'narrative', 'Короткий по продолжительности мод');

INSERT INTO tags VALUES (DEFAULT, 'Хоррор', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Мистика', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Драма', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Детектив', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Бесконечные циклы', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Триллер', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Приключения', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Комедия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Трагикомедия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Трагедия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Ангст', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Романтика', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Повседневность', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Фантастика', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Научная фантастика', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Альтернативная история', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Психоделика', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Мрачный', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Нуар', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Треш', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Антиутопия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Утопия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Философия', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Технический', '#6b6b6b', 'genre', NULL);
INSERT INTO tags VALUES (DEFAULT, 'Не противоречит канону', '#6b6b6b', 'genre', NULL);

INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Алиса'), 'Алисы');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Лена'), 'Лены');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Славя'), 'Славии');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Ульяна'), 'Ульяны');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Юля'), 'Юли');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Ольга'), 'Ольги');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Виола'), 'Виолы');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Пионер'), 'Пионера');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Пионер'), 'Пионеру');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Хоррор'), 'Ужасы');
INSERT INTO tag_similar_names (tag_id, similar_name) VALUES ((SELECT tags.id FROM tags WHERE tags.name = 'Психоделика'), 'Психоделический');

