Create DB (Postgres - PostgreSQL\9.6\bin>psql -U postgres darklands_host_builder):
\copy kindred(ID,NAME) FROM '/path/to/csv/Kindreds.csv' DELIMITER ',' CSV
\copy token(ID,NAME) FROM '/path/to/csv/Tokens.csv' DELIMITER ',' CSV
\copy kin(ID,NAME) FROM '/path/to/csv/Kins.csv' DELIMITER ',' CSV
\copy kin_kindreds(KIN_ID,KINDRED_ID) FROM '/path/to/csv/Kin_Kindreds.csv' DELIMITER ',' CSV
\copy acuity(ID,NAME) FROM '/path/to/csv/Acuities.csv' DELIMITER ',' CSV
\copy privilege(ID,NAME) FROM '/path/to/csv/Privileges.csv' DELIMITER ',' CSV
\copy warriorclass(ID,NAME) FROM '/path/to/csv/Classes.csv' DELIMITER ',' CSV
\copy profile(ID,AUTHORITY,CONSTITUTION,FORTITUDE,MIGHT,PACE,SKILL,TEMPER) FROM '/path/to/csv/Profiles.csv' DELIMITER ',' CSV
\copy warrior(ID,NAME,SPELLING,KINDRED_ID,PRIVILEGE_ID,ACUITY_ID,HANDS,UNITESIZEMIN,UNITESIZEMAX,BASESIZE,COST,PROFILE_ID) FROM '/path/to/csv/Warriors.csv' DELIMITER ',' CSV
\copy warrior_classes(WARRIOR_ID,WARRIORCLASS_ID) FROM '/path/to/csv/Warrior_Classes.csv' DELIMITER ',' CSV
\copy warrior_kin(WARRIOR_ID,KIN_ID) FROM '/path/to/csv/Warrior_Kins.csv' DELIMITER ',' CSV
\copy warrior_token(WARRIOR_ID,TOKEN_ID) FROM '/path/to/csv/Warrior_Tokens.csv' DELIMITER ',' CSV
\copy ubiquity(ID,NAME) FROM '/path/to/csv/Ubiquities.csv' DELIMITER ',' CSV
\copy realm(ID,NAME,KINDRED_ID) FROM '/path/to/csv/Realms.csv' DELIMITER ',' CSV
\copy warriorubiquity(ID,WARRIOR_ID,REALM_ID,UBIQUITY_ID,UBIQUITY_AMOUNT) FROM '/path/to/csv/Warrior_Ubiquities.csv' DELIMITER ',' CSV
\copy specialrule(ID,NAME) FROM '/path/to/csv/SpecialRules.csv' DELIMITER ',' CSV
\copy profile_specialrule(PROFILE_ID,SPECIALRULE_ID) FROM '/path/to/csv/Profile_Specialrules.csv' DELIMITER ',' CSV
\copy miniature(ID,articlenumber,image,link,name) FROM '/path/to/csv/Miniatures.csv' DELIMITER ',' CSV
\copy profile_miniature(PROFILE_ID,MINIATURE_ID) FROM '/path/to/csv/Miniature_Profile.csv' DELIMITER ',' CSV
\copy equipmenttype(ID,NAME) FROM '/path/to/csv/EquipmentTypes.csv' DELIMITER ',' CSV
\copy equipmentclass(ID,NAME) FROM '/path/to/csv/EquipmentClasses.csv' DELIMITER ',' CSV
\copy equipment(ID,NAME,OPTION,EQUIPMENT_TYPE_ID,HANDS,EQUIPMENT_CLASS_ID,COST) FROM '/path/to/csv/Equipments.csv' DELIMITER ',' CSV
\copy combatweapon(ID,ATTACKDICE,WEAPONPLUS,MANDW,ATTACKRANGE,CHARGEPLUS,MANDWANDCH,WOUNDPLUS,EQUIPMENT_ID,WARRIOR_ID) FROM '/path/to/csv/CombatWeapons.csv' DELIMITER ',' CSV
\copy armour(ID,ARMOURPLUS,CANDA,WOUNDMINUS,EQUIPMENT_ID,WARRIOR_ID) FROM '/path/to/csv/Armours.csv' DELIMITER ',' CSV
\copy shotweapon(ID,SHOOTDICE,GAZEDAMAGE,GLANCEDAMAGE,MINIMUMRANGE,LETHALRANGE,EFFECTIVERANGE,MAXIMUMRANGE,WOUNDPLUS,EQUIPMENT_ID,WARRIOR_ID) FROM '/path/to/csv/ShotWeapons.csv' DELIMITER ',' CSV

Warrior.csv:
id/name/spelling/kindred/Privilege/Acuity/Hands/UnitSizeMin/UnitSizeMax/BaseSize/Cost/Profile_ID

Image to bytea:
Step 1 (convert the image to base64 string)
INSERT INTO images (image_name, image_data)
VALUES( 'image_one', decode('', 'base64') );