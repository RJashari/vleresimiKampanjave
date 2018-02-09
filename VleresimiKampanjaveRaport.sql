select Users.username , Dega.emri from Users inner join Dega on Users.DegaID = Dega.DegaID 
select Users.username, Klienti.klientInfo from Users inner join Klienti on Users.userID = Klienti.userID

select Klienti.klientInfo, Users.username , Dega.emri from Users inner join Dega on Users.DegaID = Dega.DegaID 
inner join Klienti on Users.userID = Klienti.userID

select Klienti.klientInfo, Dega.emri, Pytesori.* from Users inner join Dega on Users.DegaID = Dega.DegaID 
inner join Klienti on Users.userID = Klienti.userID inner join Pytesori on Pytesori.KlientID = Klienti.nrPersonal where Dega.emri = 'Prishtine';