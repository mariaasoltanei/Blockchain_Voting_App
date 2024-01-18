#![no_std]

multiversx_sc::imports!(); // Imports macros from multiversx-sc crate.

#[derive(Encode, Decode, Clone, PartialEq, Eq, Debug)]
#[derive(TopEncode, TopDecode)]
pub struct VotingSession {
    name: String,
    description: String,
    options: Vec<String>
}

#[multiversx_sc::contract] // Marks the struct as a contract.
pub trait VotingContract {

    #[view(getAdmin)] // Marks the function as a view function.
    #[storage_mapper("admin")] // Storage variable to store sum.
    fn admin(&self) -> SingleValueMapper<String>;

    #[view(getVotingSessions)] // Marks the function as a view function.
    #[storage_mapper("voting_sessions")] // Storage variable to store sum.
    fn voting_sessions(&self) -> SingleValueMapper<Vec<VotingSession>>;

    #[view(getVotingSession)] // Marks the function as a view function.
    fn getVotingSession(&self, name: String) -> Option<VotingSession> {
        let voting_sessions = self.voting_sessions().get();
        for voting_session in voting_sessions {
            if voting_session.name == name {
                return Some(voting_session);
            }
        }
        None
    }


    [payable(*)]
    #[endpoint(createVotingSession)] // Marks the function as an endpoint.
    fn createVotingSession(&self, votingSession: VotingSession) {
        let mut voting_sessions = self.voting_sessions().get();
        self.voting_sessions().set(voting_sessions.push(votingSession));
    }

    #[init] // Marks the function as an initializer.
    fn init(&self, initial_value: BigUint) {
        self.admin().set(self.context().sender().bech32());
        self.voting_sessions().set(Vec::new());
    }
}