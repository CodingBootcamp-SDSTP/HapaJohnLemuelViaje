DROP TABLE comments;
DROP TABLE up;
DROP TABLE followers;
DROP TABLE following;
DROP TABLE posts;
DROP TABLE locations;
DROP TABLE users;

CREATE TABLE IF NOT EXISTS users (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	image VARCHAR(255) NOT NULL,
	registered_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	followers INTEGER NOT NULL,
	following INTEGER NOT NULL,
	status INTEGER NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	deleted_date DATETIME,
	posts INTEGER NOT NULL
);

INSERT INTO users ( firstname, lastname, email, image, followers, following, status, username, password, posts ) VALUES ( 'John Lemuel', 'Hapa', 'johnlemuel.hapa@bicol-u.edu.ph', '2.jpg', 0, 0, 1, 'johnlemuelhapa', 'hapa101', 1 );

INSERT INTO users ( firstname, lastname, email, image, followers, following, status, username, password, posts ) VALUES ( 'William', 'Paderan', 'williamphilip.paderan@bicol-u.edu.ph', 'wolfpack.jpg', 0, 0, 1, 'williampaderan', 'wil101', 0 );

CREATE TABLE IF NOT EXISTS locations (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	location_name VARCHAR(255) NOT NULL,
	image VARCHAR(255) NOT NULL
);

INSERT INTO locations ( location_name, image ) VALUES ( 'Andorra', 'Andorra.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'United Arab Emirates', 'UnitedArabEmirates.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Afghanistan', 'Afghanistan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Antigua and Barbuda', 'AntiguaAndBarbuda.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Anguilla', 'Anguilla.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Albania', 'Albania.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Armenia', 'Armenia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Angola', 'Angola.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Antarctica', 'Antarctica.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Argentina', 'Argentina.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'American Samoa', 'AmericanSamoa.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Austria', 'Austria.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Australia', 'Australia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Aruba', 'Aruba.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Åland Islands', 'ÅlandIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Azerbaijan', 'Azerbaijan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bosnia and Herzegovina', 'BosniaAndHerzegovina.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Barbados', 'Barbados.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bangladesh', 'Bangladesh.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Belgium', 'Belgium.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'BurkinaFaso', 'BurkinaFaso.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bulgaria', 'Bulgaria.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bahrain', 'Bahrain.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Burundi', 'Burundi.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Benin', 'Benin.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Barthélemy', 'SaintBarthélemy.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bermuda', 'Bermuda.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Brunei Darussalam', 'BruneiDarussalam.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bolivia, Plurinational State of', 'BoliviaPlurinationalStateOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Caribbean Netherlands', 'CaribbeanNetherlands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Brazil', 'Brazil.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bahamas', 'Bahamas.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bhutan', 'Bhutan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Bouvet Island', 'BouvetIsland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Botswana', 'Botswana.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Belarus', 'Belarus.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Belize', 'Belize.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Canada', 'Canada.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cocos (Keeling) Islands', 'Cocos(Keeling)Islands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Congo, the Democratic Republic of the', 'CongoTheDemocraticRepublicOfThe.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Central African Republic', 'CentralAfricanRepublic.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Congo', 'Congo.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Switzerland', 'Switzerland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( "Côte d'Ivoire", "Côted'Ivoire.svg" );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cook Islands', 'CookIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Chile', 'Chile.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cameroon', 'Cameroon.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'China', 'China.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Colombia', 'Colombia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Costa Rica', 'CostaRica.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cuba', 'Cuba.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cape Verde', 'CapeVerde.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Curaçao', 'Curaçao.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Christmas Island', 'ChristmasIsland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cyprus', 'Cyprus.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Czech Republic', 'CzechRepublic.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Germany', 'Germany.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Djibouti', 'Djibouti.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Denmark', 'Denmark.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Dominica', 'Dominica.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Dominican Republic', 'DominicanRepublic.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Algeria', 'Algeria.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Ecuador', 'Ecuador.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Estonia', 'Estonia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Egypt', 'Egypt.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Western Sahara', 'WesternSahara.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Eritrea', 'Eritrea.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Spain', 'Spain.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Ethiopia', 'Ethiopia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Finland', 'Finland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Fiji', 'Fiji.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Falkland Islands (Malvinas)', 'FalklandIslands(Malvinas).svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Micronesia, Federated States of', 'MicronesiaFederatedStatesOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Faroe Islands', 'FaroeIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'France', 'France.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Gabon', 'Gabon.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'England', 'England.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Northern Ireland', 'NorthernIreland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Scotland', 'Scotland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Wales', 'Wales.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'United Kingdom', 'UnitedKingdom.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Grenada', 'Grenada.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Georgia', 'Georgia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'French Guiana', 'FrenchGuiana.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guernsey', 'Guernsey.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Ghana', 'Ghana.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Gibraltar', 'Gibraltar.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Greenland', 'Greenland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Gambia', 'Gambia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guinea', 'Guinea.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guadeloupe', 'Guadeloupe.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Equatorial Guinea', 'EquatorialGuinea.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Greece', 'Greece.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'South Georgia and the South Sandwich Islands', 'SouthGeorgiaAndTheSouthSandwichIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guatemala', 'Guatemala.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guam', 'Guam.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guinea-Bissau', 'GuineaBissau.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Guyana', 'Guyana.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Hong Kong', 'HongKong.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Heard Island and McDonald Islands', 'HeardIslandAndMcDonaldIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Honduras', 'Honduras.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Croatia', 'Croatia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Haiti', 'Haiti.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Hungary', 'Hungary.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Indonesia', 'Indonesia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Ireland', 'Ireland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Israel', 'Israel.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Isle of Man', 'IsleOfMan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'India', 'India.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'British Indian Ocean Territory', 'BritishIndianOceanTerritory.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Iraq', 'Iraq.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Iran, Islamic Republic of', 'IranIslamicRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Iceland', 'Iceland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Italy', 'Italy.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Jersey', 'Jersey.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Jamaica', 'Jamaica.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Jordan', 'Jordan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Japan', 'Japan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kenya', 'Kenya.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kyrgyzstan', 'Kyrgyzstan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cambodia', 'Cambodia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kiribati', 'Kiribati.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Comoros', 'Comoros.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Kitts and Nevis', 'SaintKittsAndNevis.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( "Korea, Democratic People's Republic of", 'KoreaDemocraticPeoplesRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Korea, Republic of', 'KoreaRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kuwait', 'Kuwait.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Cayman Islands', 'CaymanIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kazakhstan', 'Kazakhstan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( "Lao People's Democratic Republic", 'LaoPeoplesDemocraticRepublic.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Lebanon', 'Lebanon.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Lucia', 'SaintLucia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Liechtenstein', 'Liechtenstein.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sri Lanka', 'SriLanka.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Liberia', 'Liberia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Lesotho', 'Lesotho.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Lithuania', 'Lithuania.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Luxembourg', 'Luxembourg.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Latvia', 'Latvia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Libya', 'Libya.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Morocco', 'Morocco.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Monaco', 'Monaco.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Moldova, Republic of', 'MoldovaRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Montenegro', 'Montenegro.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Martin', 'SaintMartin.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Madagascar', 'Madagascar.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Marshall Islands', 'MarshallIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Macedonia, the former Yugoslav Republic of', 'MacedoniaTheFormerYugoslavRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mali', 'Mali.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Myanmar', 'Myanmar.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mongolia', 'Mongolia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Macao', 'Macao.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Northern Mariana Islands', 'NorthernMarianaIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Martinique', 'Martinique.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mauritania', 'Mauritania.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Montserrat', 'Montserrat.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Malta', 'Malta.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mauritius', 'Mauritius.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Maldives', 'Maldives.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Malawi', 'Malawi.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mexico', 'Mexico.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Malaysia', 'Malaysia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mozambique', 'Mozambique.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Namibia', 'Namibia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'New Caledonia', 'NewCaledonia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Niger', 'Niger.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Norfolk Island', 'NorfolkIsland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Nigeria', 'Nigeria.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Nicaragua', 'Nicaragua.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Netherlands', 'Netherlands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Norway', 'Norway.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Nepal', 'Nepal.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Nauru', 'Nauru.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Niue', 'Niue.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'New Zealand', 'NewZealand.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Oman', 'Oman.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Panama', 'Panama.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Peru', 'Peru.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'French Polynesia', 'FrenchPolynesia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Papua New Guinea', 'PapuaNewGuinea.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Philippines', 'Philippines.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Pakistan', 'Pakistan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Poland', 'Poland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Pierre and Miquelon', 'SaintPierreAndMiquelon.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Pitcairn', 'Pitcairn.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Puerto Rico', 'PuertoRico.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Palestine', 'Palestine.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Portugal', 'Portugal.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Palau', 'Palau.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Paraguay', 'Paraguay.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Qatar', 'Qatar.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Réunion', 'Réunion.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Romania', 'Romania.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Serbia', 'Serbia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Russian Federation', 'RussianFederation.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Rwanda', 'Rwanda.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saudi Arabia', 'SaudiArabia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Solomon Islands', 'SolomonIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Seychelles', 'Seychelles.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sudan', 'Sudan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sweden', 'Sweden.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Singapore', 'Singapore.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Helena, Ascension and Tristan da Cunha', 'SaintHelenaAscensionAndTristanDaCunha.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Slovenia', 'Slovenia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Svalbard and Jan Mayen Islands', 'SvalbardAndJanMayenIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Slovakia', 'Slovakia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sierra Leone', 'Sierra Leone.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'San Marino', 'SanMarino.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Senegal', 'Senegal.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Somalia', 'Somalia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Suriname', 'Suriname.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'South Sudan', 'SouthSudan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sao Tome and Principe', 'SaoTomeAndPrincipe.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'El Salvador', 'ElSalvador.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Sint Maarten (Dutch part)', 'SintMaarten(Dutch part).svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Syrian Arab Republic', 'SyrianArabRepublic.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Swaziland', 'Swaziland.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Turks and Caicos Islands', 'TurksAndCaicosIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Chad', 'Chad.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'French Southern Territories', 'FrenchSouthernTerritories.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Togo', 'Togo.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Thailand', 'Thailand.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tajikistan', 'Tajikistan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tokelau', 'Tokelau.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Timor-Leste', 'Timor-Leste.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Turkmenistan', 'Turkmenistan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tunisia', 'Tunisia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tonga', 'Tonga.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Turkey', 'Turkey.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Trinidad and Tobago', 'TrinidadAndTobago.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tuvalu', 'Tuvalu.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Taiwan, Province of China', 'TaiwanProvinceOfChina.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Tanzania, United Republic of', 'TanzaniaUnitedRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Ukraine', 'Ukraine.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Uganda', 'Uganda.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'US Minor Outlying Islands', 'USMinorOutlyingIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'United States', 'UnitedStates.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Uruguay', 'Uruguay.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Uzbekistan', 'Uzbekistan.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Holy See (Vatican City State)', 'HolySee(VaticanCityState).svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Saint Vincent and the Grenadines', 'SaintVincentAndTheGrenadines.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Venezuela, Bolivarian Republic of', 'VenezuelaBolivarianRepublicOf.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Virgin Islands, British', 'VirginIslandsBritish.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Virgin Islands, U.S.', 'VirginIslandsUS.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Viet Nam', 'VietNam.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Vanuatu', 'Vanuatu.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Wallis and Futuna Islands', 'WallisAndFutunaIslands.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Kosovo', 'Kosovo.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Samoa', 'Samoa.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Yemen', 'Yemen.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Mayotte', 'Mayotte.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'South Africa', 'SouthAfrica.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Zambia', 'Zambia.svg' );
INSERT INTO locations ( location_name, image ) VALUES ( 'Zimbabwe', 'Zimbabwe.svg' );

CREATE TABLE IF NOT EXISTS posts (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	user_id INTEGER NOT NULL,
	location_id INTEGER NOT NULL,
	address VARCHAR(255) NOT NULL,
	image VARCHAR(255) NOT NULL,
	date_entry DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	date_deleted DATETIME,
	caption VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	up INTEGER NOT NULL,
	comments INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (location_id) REFERENCES locations(id)
);

INSERT INTO posts ( user_id, location_id, address, image, caption, status, up, comments ) VALUES ( 1, 181, 'Banawe', 'bg.jpg', 'It is more fun in the Philippines', 1, 1, 1 );

CREATE TABLE IF NOT EXISTS comments (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	post_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	comment VARCHAR(255) NOT NULL,
	date_entry DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	date_deleted DATETIME,
	status INTEGER NOT NULL,
	FOREIGN KEY (post_id) REFERENCES posts(id),
	FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO comments ( post_id, user_id, comment, status ) VALUES ( 1, 2, 'Wow ang ganda naman tlga dyan', 1 );

CREATE TABLE IF NOT EXISTS up (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	post_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	date DATETIME NOT NULL,
	status VARCHAR(255) NOT NULL,
	FOREIGN KEY (post_id) REFERENCES posts(id),
	FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO up ( post_id, user_id, date, status ) VALUES ( 1, 2, '2018-06-20 08:41:10', 1 );

CREATE TABLE IF NOT EXISTS followers (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	user_id INTEGER NOT NULL,
	date DATETIME NOT NULL,
	status VARCHAR(255) NOT NULL,
	whoFollow_id INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (whoFollow_id) REFERENCES users(id)
);

INSERT INTO followers ( user_id, date, status, whoFollow_id ) VALUES ( 1, '2018-06-20 09:02:10', 1, 2 );
INSERT INTO followers ( user_id, date, status, whoFollow_id ) VALUES ( 2, '2018-06-20 09:02:10', 1, 1 );

CREATE TABLE IF NOT EXISTS following (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	user_id INTEGER NOT NULL,
	date DATETIME NOT NULL,
	status VARCHAR(255) NOT NULL,
	youFollow_id INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (youFollow_id) REFERENCES users(id)
);

INSERT INTO following ( user_id, date, status, youFollow_id ) VALUES ( 2, '2018-06-20 09:03:12', 1, 1 );
INSERT INTO following ( user_id, date, status, youFollow_id ) VALUES ( 1, '2018-06-20 09:03:12', 1, 2 );