INSERT INTO Kindred
	(id, name)
VALUES (1, 'Fomoraic');

INSERT INTO Kindred
	(id, name)
VALUES (2, 'Erainn');

INSERT INTO Kindred
	(id, name)
VALUES (3, 'Norse');

INSERT INTO Kindred
	(id, name)
VALUES (4, 'Infernii');

INSERT INTO Kindred
	(id, name)
VALUES (5, 'Byzantii');

INSERT INTO Kindred
	(id, name)
VALUES (6, 'Anglecynn');

INSERT INTO Kindred
	(id, name)
VALUES (7, 'Albainn');

INSERT INTO Kin
  (id, name, kindred_id)
VALUES (1, 'Scion of Baalor', 1);

INSERT INTO Kin
  (id, name, kindred_id)
VALUES (2, 'Warrior of Baalor', 1);

INSERT INTO Acuity
  (id, name)
VALUES (1, 'Elite');

INSERT INTO Privilege
  (id, name)
VALUES (1, 'Noble');

INSERT INTO WarriorClass
  (id, name)
VALUES (1, 'Warlord');

INSERT INTO Profile
  (id, pace, skill, might, constitution, fortitude, authority, temper)
VALUES (1, 6, 87, 73, 66, 96, 97, 86);

INSERT INTO Profile
  (id, pace, skill, might, constitution, fortitude, authority, temper)
VALUES (2, 6, 81, 66, 54, 92, 91, 72);

INSERT INTO Warrior
  (id, name, cost, hands, basesize, sellsword, spelling, unitsizemax, unitsizemin, acuity_id, kin_id, kindred_id, privilege_id, warrior_class_id, profile_id)
VALUES (1, 'Belech', 560, 2, 80, false, 'BEL-ekh', 1, 1, 1, 1, 1, 1, 1, 1);

INSERT INTO Warrior
  (id, name, cost, hands, basesize, sellsword, spelling, unitsizemax, unitsizemin, acuity_id, kin_id, kindred_id, privilege_id, warrior_class_id, profile_id)
VALUES (2, 'Scion of Baalor', 394, 2, 80, false, 'SEYE-on of BAL-or', 1, 1, 1, 1, 1, 1, 1, 2);